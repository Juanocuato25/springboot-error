package com.jarenas.curso.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.jarenas.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.jarenas.curso.springboot.error.springboot_error.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception ex){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division por cero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        //return ResponseEntity.internalServerError().body(error);
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    } 

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundException(NoHandlerFoundException ex){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("ApiRest no encontrado");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(NumberFormatException ex){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("Error", "Numero invalido/Incorrecto, no tiene formato de digito");
        error.put("Message", ex.getMessage());
        error.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception ex){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("Error", "El usurio o rol o existe");
        error.put("Message", ex.getMessage());
        error.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

}
