package com.github.emeps.cars.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.Collection;

@Getter
public class DefaultErrorCars {
    private final String message;
    private  final Integer status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Collection<ValidationError> errors;

    public DefaultErrorCars(HttpStatus status, Collection<ValidationError> errors) {
        this.message = "Check the 'errors' property for more details.";
        this.status = status.value();
        this.errors = errors;
    }

    public DefaultErrorCars(String message, HttpStatusCode status){
        this.message = message;
        this.status= status.value();
        this.errors = null;
    }
}
