package br.com.cotiinformatica.apifinancas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CriarException.class)
    public ResponseEntity<?> handleNotFoundException(CriarException criarException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR: " +  criarException.getMessage());
    }

}
