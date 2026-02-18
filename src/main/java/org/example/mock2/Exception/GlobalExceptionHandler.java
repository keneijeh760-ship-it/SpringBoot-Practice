package org.example.mock2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiExceptions apiExceptions = new ApiExceptions(
                e.getMessage(),
                e,
                status,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiExceptions, status);
    }
}
