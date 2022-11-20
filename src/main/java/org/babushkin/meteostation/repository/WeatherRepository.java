package org.babushkin.meteostation.repository;

import org.babushkin.meteostation.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
//    @Query(value = "SELECT w FROM weather w WHERE w.source_id = :source_id ORDER BY date DESC LIMIT 1")
//    List<Weather> getLastWeather(@Param("source_id") long id);
}
