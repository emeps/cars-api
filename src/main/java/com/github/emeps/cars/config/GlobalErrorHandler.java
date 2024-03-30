package com.github.emeps.cars.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public  ResponseEntity<Map<String, ?>> status (ResponseStatusException exception){
        return ResponseEntity.status(exception.getStatusCode()).body(
                Map.of(
                        "status", exception.getStatusCode().value(),
                        "message", Optional.ofNullable(exception.getReason()).orElse("")
                )
        );
    }
}
