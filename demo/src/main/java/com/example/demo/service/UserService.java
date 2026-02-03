package com.example.demo.service;

import com.example.demo.Exception.CustomException;
import com.example.demo.Exception.ErrorCode;
import com.example.demo.config.jwt.JwtUtil;
import com.example.demo.data.dto.requestDTO.LoginRequestDTO;
import com.example.demo.data.dto.requestDTO.SignUpRequestDTO;
import com.example.demo.data.dto.responseDTO.AnonymousLoginResponseDTO;
import com.example.demo.data.dto.responseDTO.CommonResponseDTO;
import com.example.demo.data.entity.user.AnonymousUser;
import com.example.demo.data.entity.user.LoginUser;
import com.example.demo.data.enumerate.UserRole;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.util.UuidMaker;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    @Value("${admin.secret.key}")
    private String adminKey;

    @Transactional
    public CommonResponseDTO signUp(@Valid SignUpRequestDTO signUpRequestDTO) {
        if (findLoginUserByEmail(signUpRequestDTO.getEmail()).isPresent()) {
            throw new CustomException(ErrorCode.ALREADY_EXIST_USER);
        }

        String encodedPassword = passwordEncoder.encode(signUpRequestDTO.getPassword());
        UserRole userRole = isAdmin(signUpRequestDTO.getAdminKey());

        LoginUser loginUser = new LoginUser(encodedPassword, signUpRequestDTO, userRole);
        userRepository.save(loginUser);

        return CommonResponseDTO.builder()
                .message("회원가입 완료")
                .build();
    }

    @Transactional(readOnly = true)
    public CommonResponseDTO login(LoginRequestDTO loginRequestDTO, HttpServletResponse response) {
        LoginUser loginUser = findLoginUserByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_USER));

        if(!passwordEncoder.matches(loginRequestDTO.getPassword(), loginUser.getPassword())) {
            throw new CustomException(ErrorCode.NOT_EQUALS_PASSWORD);
        }

        String token = jwtUtil.createToken(loginUser.getEmail(), loginUser.getUserRole());
        response.addHeader(HttpHeaders.AUTHORIZATION, token);

        return CommonResponseDTO.builder()
                .body(token)
                .message("로그인 성공")
                .build();
    }

    @Transactional
    public CommonResponseDTO anonymousLogin(HttpServletResponse response) {
        String anonymousId = UuidMaker.createUuid();
        AnonymousUser anonymousUser = new AnonymousUser(anonymousId);
        AnonymousUser save = userRepository.save(anonymousUser);

        String token = jwtUtil.createToken(save.getAnonymousId(), save.getUserRole());
        response.addHeader(HttpHeaders.AUTHORIZATION, token);

        AnonymousLoginResponseDTO responseDTO = AnonymousLoginResponseDTO.builder()
                .token(token)
                .anonymousId(anonymousId)
                .build();

        return CommonResponseDTO.builder()
                .body(responseDTO)
                .message("익명사용자 생성 완료")
                .build();
    }

    @Transactional(readOnly = true)
    public Optional<LoginUser> findLoginUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public Optional<AnonymousUser> findAnonymousUserById(String id) {
        return userRepository.findByAnonymousId(id);
    }

    private UserRole isAdmin(String requestAdminKey) {
        UserRole userRoleEnum = UserRole.USER;
        if (requestAdminKey.equals(adminKey)) {
            userRoleEnum = UserRole.ADMIN;
        }
        if (!requestAdminKey.isEmpty() && !requestAdminKey.equals(adminKey)) {
            throw new CustomException(ErrorCode.NOT_EQUALS_ADMIN_KEY);
        }
        return userRoleEnum;
    }
}
