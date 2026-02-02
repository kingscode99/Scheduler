package com.example.demo.Exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    NOT_EXIST_USER("사용자가 존재하지 않습니다.", HttpStatus.BAD_REQUEST),
    NOT_VALIDATE_TOKEN("토큰이 유효하지 않습니다", HttpStatus.UNAUTHORIZED);

    private final String errorMessage;
    private final HttpStatus httpStatus;
}
