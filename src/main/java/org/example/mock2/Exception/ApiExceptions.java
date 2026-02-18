package org.example.mock2.Exception;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;


public class ApiExceptions {
    private String message;
    private Throwable cause;
    private HttpStatus status;
    private ZonedDateTime timestamp;

    public ApiExceptions(String message, Throwable cause, HttpStatus status, ZonedDateTime timestamp) {
        this.message = message;
        this.cause = cause;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Throwable getCause() {
        return cause;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
