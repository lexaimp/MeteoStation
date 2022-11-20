package org.babushkin.meteostation.repository;

import org.babushkin.meteostation.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    @Query(value = "SELECT * FROM weather w WHERE w.sourceId = || :id || ORDER BY date DESC LIMIT 1")
    Weather getLastWeather(@Param("sourceId") long id);
}
