package org.babushkin.meteostation.advice;

import org.babushkin.meteostation.exception.WeatherSourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.http.WebSocketHandshakeException;

@ControllerAdvice
public class WeatherSourceNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(WebSocketHandshakeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String weatherNotFoundHandler(WeatherSourceNotFoundException ex) {
        return ex.getMessage();
    }
}
