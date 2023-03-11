package org.babushkin.meteostation.repository;

import org.babushkin.meteostation.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    Weather findTopBySourceIdOrderByDateDesc(long id);

    @Query(value = "SELECT w.air_temperature FROM weather w WHERE w.id = 1", nativeQuery = true)
    double test();
}
