package com.sai.order.exception;

import com.sai.order.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateOrderException.class)
    public ResponseEntity<ApiResponse<Void>> handleDuplicateOrder(
            DuplicateOrderException ex) {

        ApiResponse<Void> response = new ApiResponse<>(
                false,
                ex.getMessage(),
                null
        );

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneralException(
            Exception ex) {

        ApiResponse<Void> response = new ApiResponse<>(
                false,
                "Something went wrong",
                null
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
