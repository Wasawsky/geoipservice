package com.ml.info.controller;

import com.ml.info.exception.CustomException;
import com.ml.info.model.ResponseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Rest confroller advice
 */
@RestControllerAdvice
public class AdviceController {

    /**
     * Manejo de excepcion interna
     * @param exception custom exception
     * @return Response Entity Response Error
     */
    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<ResponseError> handleCustomException(CustomException exception){
        return ResponseEntity.badRequest().body(ResponseError.builder().code("400").message(exception.getMessage()).status("BadRequest").build());
    }

    /**
     * Manejo de excepcion general
     * @param exception custom exception
     * @return Response Entity Response Error
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseError> handleAllException(Exception exception){
        return ResponseEntity.internalServerError().body(ResponseError.builder().code("500").message(exception.getMessage()).status("Error").build());
    }
}
