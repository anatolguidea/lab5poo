package com.example.demo.config;

import com.example.demo.exceptions.AlreadyExistsException;
import com.example.demo.exceptions.NotFoundError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerConfig {
    @ExceptionHandler(NotFoundError.class)
    private ResponseEntity<Object> NotFoundError(NotFoundError notFoundException) {
        Map<String, String> map = new HashMap<>();

        map.put("timestamp", Instant.now().toString());
        map.put("message", notFoundException.getMessage());
        map.put("status", notFoundException.getStatus().toString());

        return ResponseEntity.status(notFoundException.getStatus()).body(map);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    private ResponseEntity<Object> alreadyExistException(AlreadyExistsException alreadyExistException) {
        Map<String, String> map = new HashMap<>();

        map.put("timestamp", Instant.now().toString());
        map.put("message", alreadyExistException.getMessage());
        map.put("status", alreadyExistException.getStatus().toString());

        return ResponseEntity.status(alreadyExistException.getStatus()).body(map);
    }
}
