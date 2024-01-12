package com.example.demo.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends RuntimeException{

    private String message;

    private HttpStatus status = HttpStatus.CONFLICT;

    public AlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
