package org.babushkin.meteostation.advice;

import org.babushkin.meteostation.exception.WeatherNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.http.WebSocketHandshakeException;

@ControllerAdvice
public class WeatherNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(WebSocketHandshakeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String weatherNotFoundHandler(WeatherNotFoundException ex) {
        return ex.getMessage();
    }
}
