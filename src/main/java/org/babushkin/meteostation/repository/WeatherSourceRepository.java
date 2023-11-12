package org.babushkin.meteostation.repository;

import org.babushkin.meteostation.model.WeatherSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WeatherSourceRepository extends JpaRepository<WeatherSource, Long> {

    Optional<WeatherSource> findByMacAddress(String mac);

    Optional<WeatherSource> findByComment(String comment);

    @Query(value = "SELECT ws.id FROM weather_source ws WHERE ws.mac_address = :mac", nativeQuery = true)
    long getIdByMacAddress(@Param("mac") String mac);
}
