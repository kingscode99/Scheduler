package com.example.demo.controller;

import com.example.demo.data.dto.requestDTO.LoginRequestDTO;
import com.example.demo.data.dto.requestDTO.SignUpRequestDTO;
import com.example.demo.data.dto.responseDTO.CommonResponseDTO;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<CommonResponseDTO> signUp(@Valid @RequestBody SignUpRequestDTO signUpRequestDTO) {
        return ResponseEntity.ok(userService.signUp(signUpRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse response) {
        return ResponseEntity.ok(userService.login(loginRequestDTO, response));
    }

    @PostMapping("/anonymous/login")
    public ResponseEntity<CommonResponseDTO> anonymousLogin(HttpServletResponse response) {
        return ResponseEntity.ok(userService.anonymousLogin(response));
    }
}
