package org.babushkin.meteostation.repository;

import org.babushkin.meteostation.model.WeatherSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherSourceRepository extends JpaRepository<WeatherSource, Long> {
}
