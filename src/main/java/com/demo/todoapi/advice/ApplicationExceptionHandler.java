package com.demo.todoapi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handlerInvalidRequest( MethodArgumentNotValidException exception){
        return  exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(  FieldError::getField, FieldError::getDefaultMessage,
                        (existing, replacement) -> existing ));
    }

}
