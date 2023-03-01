package org.babushkin.meteostation.controller;

import org.babushkin.meteostation.exception.WeatherSourceNotFoundException;
import org.babushkin.meteostation.model.WeatherSource;
import org.babushkin.meteostation.repository.WeatherSourceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/sourceId/{mac}")
    WeatherSource one(@PathVariable String mac) {
        return (WeatherSource) repository.findByMacAddress(mac).orElseThrow(() -> new WeatherSourceNotFoundException(mac));

    }

    @GetMapping("/sourceId")
    long id (@RequestBody String mac) {
        return repository.findByMacAddress(mac).getId();
    }
}
