package org.babushkin.meteostation.controller;

import org.babushkin.meteostation.exception.WeatherNotFoundException;
import org.babushkin.meteostation.exception.WeatherSourceNotFoundException;
import org.babushkin.meteostation.model.WeatherSource;
import org.babushkin.meteostation.repository.WeatherSourceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherSourceController {

    private final WeatherSourceRepository repository;

    public WeatherSourceController(WeatherSourceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/allSources")
    List<WeatherSource> all() {
        return repository.findAll();
    }



    @GetMapping("api/v1/source/{mac}")
    WeatherSource one(@PathVariable String mac) {
        return repository.findByMacAddress(mac).orElseThrow(() -> new WeatherSourceNotFoundException(mac));
    }

    @GetMapping("api/v1/source2/{comment}")
    WeatherSource getComment(@PathVariable String comment) {
        return repository.findByComment(comment).orElseThrow(() -> new WeatherSourceNotFoundException(comment));
    }

    @PostMapping("api/v1/source")
    WeatherSource newWeatherSource(@RequestBody WeatherSource weatherSource) {
        if (weatherSource.getName() == null || weatherSource.getName().isEmpty()) {
            throw new RuntimeException("name cannot be empty or null"); // TODO Переписать чтобы ошибка вовращалась в ответе json-ом
        }
        return repository.save(weatherSource);
    }
}
