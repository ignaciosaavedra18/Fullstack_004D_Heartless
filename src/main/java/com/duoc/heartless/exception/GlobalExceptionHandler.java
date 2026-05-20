package com.duoc.heartless.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarError(Exception ex){

        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

// Maneja errores globales de la aplicación. Sirve para capturar excepciones y devolver mensajes más claros al usuario. 
// Ejemplo: recurso no encontrado error de validación error interno