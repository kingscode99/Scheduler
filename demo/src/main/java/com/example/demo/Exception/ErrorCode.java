package com.example.demo.Exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    NOT_EXIST_USER("사용자가 존재하지 않습니다.", HttpStatus.BAD_REQUEST),
    NOT_VALIDATE_TOKEN("토큰이 유효하지 않습니다", HttpStatus.UNAUTHORIZED),
    NOT_EQUALS_ADMIN_KEY("권한 키가 일치하지 않습니다.", HttpStatus.UNAUTHORIZED),
    ALREADY_EXIST_USER("이미 존재하는 사용자 입니다.", HttpStatus.BAD_REQUEST),
    NOT_EQUALS_PASSWORD("비밀번호가 일치하지 않습니다.", HttpStatus.UNAUTHORIZED);

    private final String errorMessage;
    private final HttpStatus httpStatus;
}
