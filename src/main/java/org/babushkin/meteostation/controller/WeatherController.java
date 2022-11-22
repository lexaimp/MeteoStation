package org.babushkin.meteostation.controller;

import org.babushkin.meteostation.exception.WeatherNotFoundException;
import org.babushkin.meteostation.model.Weather;
import org.babushkin.meteostation.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherController {

    private final WeatherRepository repository;

    public WeatherController(WeatherRepository repository) {
        this.repository = repository;
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

    @GetMapping("weather/{id}")
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