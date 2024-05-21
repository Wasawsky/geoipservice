package com.ml.info.controller;

import com.ml.info.exception.CustomException;
import com.ml.info.model.ResponseError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AdviceControllerTest {
    AdviceController adviceController = new AdviceController();

    @Test
    void testHandleCustomException() {
        ResponseEntity<ResponseError> result = adviceController.handleCustomException(new CustomException("400", "message", List.of("trace")));
        Assertions.assertTrue(result.getStatusCode().is4xxClientError());
    }

    @Test
    void testHandleAllException() {
        ResponseEntity<ResponseError> result = adviceController.handleAllException(new Exception("500", new Throwable("message")));
        Assertions.assertTrue(result.getStatusCode().is5xxServerError());
    }
}

