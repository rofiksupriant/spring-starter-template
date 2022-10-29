package com.rofik.springstartertemplate.util;

import com.rofik.springstartertemplate.dto.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    private ResponseUtil() {
    }

    public static <T> ResponseEntity<Object> build(String message, HttpStatus status, T data, T error) {
        return new ResponseEntity<>(
                ApiResponse.<T>builder()
                        .timestamp(System.currentTimeMillis())
                        .code(status.value())
                        .status(status.name())
                        .message(message)
                        .data(data)
                        .errors(error)
                        .build(),
                status
        );
    }

    public static <T> ResponseEntity<Object> ok(String message) {
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(
                ApiResponse.<T>builder()
                        .timestamp(System.currentTimeMillis())
                        .code(status.value())
                        .status(status.name())
                        .message(message)
                        .build(),
                status
        );
    }

    public static <T> ResponseEntity<Object> ok(String message, T data) {
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(
                ApiResponse.<T>builder()
                        .timestamp(System.currentTimeMillis())
                        .code(status.value())
                        .status(status.name())
                        .message(message)
                        .data(data)
                        .build(),
                status
        );
    }

    public static <T> ResponseEntity<Object> notFound(String message) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(
                ApiResponse.<T>builder()
                        .timestamp(System.currentTimeMillis())
                        .code(status.value())
                        .status(status.name())
                        .message(message)
                        .build(),
                status
        );
    }

    public static <T> ResponseEntity<Object> error(String message, HttpStatus status, T errors) {
        return new ResponseEntity<>(
                ApiResponse.<T>builder()
                        .timestamp(System.currentTimeMillis())
                        .code(status.value())
                        .status(status.name())
                        .message(message)
                        .errors(errors)
                        .build(),
                status
        );
    }
}