package com.nelio.udemy.project.resources.exceptions;

import com.nelio.udemy.project.exceptions.ResourceNotFoundException;
import com.nelio.udemy.project.services.exceptions.DataBaseException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public  class GeneralExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> notFound(ResourceNotFoundException exception, HttpServletRequest http) {
        var status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError(status.value(),
                exception.getMessage(), Instant.now(), http.getRequestURI());

        return ResponseEntity.status(status.value()).body(error);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBaseError(DataBaseException e, HttpServletRequest http) {

        var status = HttpStatus.BAD_REQUEST;

        StandardError error = new StandardError(status.value(), e.getMessage(), Instant.now(), http.getRequestURI());

        return ResponseEntity.status(status.value()).body(error);
    }
}