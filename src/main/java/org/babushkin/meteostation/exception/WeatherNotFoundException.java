package org.babushkin.meteostation.exception;

public class WeatherNotFoundException extends RuntimeException {
    public WeatherNotFoundException(Long id) {
        super("Could not find weather" + id);
    }
}
