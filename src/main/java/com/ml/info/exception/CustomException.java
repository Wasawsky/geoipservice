package com.ml.info.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Custom Exception para manejo de errores controlados
 */
@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException{

    private final String code;
    private final String message;
    private final List<String> trace;

}
