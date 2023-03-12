package org.babushkin.meteostation.controller;

import org.babushkin.meteostation.exception.WeatherNotFoundException;
import org.babushkin.meteostation.model.Weather;
import org.babushkin.meteostation.model.request.WeatherRequest;
import org.babushkin.meteostation.repository.WeatherRepository;
import org.babushkin.meteostation.repository.WeatherSourceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class WeatherController {

    private final WeatherRepository repository;
    private final WeatherSourceRepository sourceRepository;

    public WeatherController(WeatherRepository repository, WeatherSourceRepository sourceRepository) {
        this.repository = repository;
        this.sourceRepository = sourceRepository;
    }

    @GetMapping("/weather")
    List<Weather> all() {
        return repository.findAll();
    }

    @GetMapping("/currentWeather")
    Weather findByServiceId(long id) {
        return repository.findTopBySourceIdOrderByDateDesc(id);
    }

    @PostMapping("/weather")
    Weather newWeather(@RequestBody Weather newWeather) {
        return repository.save(newWeather);
    }

    @GetMapping("/test")
    double test() {
        return repository.test();
    }

    @PostMapping("api/v1/currentWeather")
    Weather newWeather(@RequestBody WeatherRequest request) {
        if (request.getMac() == null || request.getMac().isEmpty()) {
            throw new RuntimeException("mac address cannot be empty or null"); // TODO Переписать чтобы ошибка вовращалась в ответе json-ом
        }
        Weather weather = new Weather(new Date(), request.getAirTemperature(), request.getHumidity(), sourceRepository.getIdByMacAddress(request.getMac()));
        return repository.save(weather);
    }

    @GetMapping("/weather/{id}")
    Weather one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new WeatherNotFoundException(id));
    }

    @PutMapping("/weather/{id}")
    Weather replaceWeather(@RequestBody Weather newWeather, @PathVariable Long id) {
        return repository.findById(id).
                map(weather -> {
                    weather.setDate(weather.getDate());
                    weather.setAirTemperature(newWeather.getAirTemperature());
                    weather.setHumidity(newWeather.getHumidity());
                    return repository.save(weather);
                })
                .orElseGet(() -> {
                    newWeather.setId(id);
                    return repository.save(newWeather);
                });
    }

    @DeleteMapping("weather/{id}")
    void deleteWeather(@PathVariable Long id) {
        repository.deleteById(id);
    }
}