package org.babushkin.meteostation.repository;

import org.babushkin.meteostation.model.WeatherSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherSourceRepository extends JpaRepository<WeatherSource, Long> {

    Optional<WeatherRepository> findByMacAddress(String mac);
}
