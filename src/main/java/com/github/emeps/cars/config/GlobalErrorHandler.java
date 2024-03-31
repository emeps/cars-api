package com.github.emeps.cars.config;

import com.github.emeps.cars.errors.DefaultErrorCars;
import com.github.emeps.cars.errors.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public  ResponseEntity<DefaultErrorCars> handleResponseStatusException (ResponseStatusException exception){
        return ResponseEntity.status(exception.getStatusCode())
                .body(new DefaultErrorCars(exception.getReason(), exception.getStatusCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultErrorCars> handleValidation(MethodArgumentNotValidException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new DefaultErrorCars(HttpStatus.BAD_REQUEST, ValidationError.of(exception)));
    }

}
