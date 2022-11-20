package org.babushkin.meteostation.repository;

import org.babushkin.meteostation.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
