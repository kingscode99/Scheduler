package com.example.demo.Exception;

import lombok.Getter;

@Getter
public class CustomExceptionResponseDTO {

    private final int status;
    private final String error;
    private final String code;
    private final String message;

    public CustomExceptionResponseDTO(ErrorCode errorCode) {
        this.status = errorCode.getHttpStatus().value();
        this.code = errorCode.name();
        this.error = errorCode.getHttpStatus().name();
        this.message = errorCode.getErrorMessage();
    }
}
