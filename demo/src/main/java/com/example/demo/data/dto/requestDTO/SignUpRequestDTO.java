package com.example.demo.data.dto.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignUpRequestDTO {

    @Email
    private String email;

    @NotBlank
    private String nickName;

    @NotBlank
    private String password;

    private String adminKey;
}
