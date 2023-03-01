package org.babushkin.meteostation.exception;

public class WeatherSourceNotFoundException extends RuntimeException {

    public WeatherSourceNotFoundException(String mac) {
        super("Could not find weatherSource: " + mac);
    }
}
