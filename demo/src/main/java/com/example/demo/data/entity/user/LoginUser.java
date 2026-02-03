package com.example.demo.data.entity.user;

import com.example.demo.data.dto.requestDTO.SignUpRequestDTO;
import com.example.demo.data.enumerate.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("LOGIN")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LoginUser extends User {

    @Column(unique = true)
    private String email;

    private String password;

    private String nickname;

    public LoginUser(String password, @Valid SignUpRequestDTO signUpRequestDTO, UserRole userRole){
        super(userRole);
        this.password = password;
        this.nickname = signUpRequestDTO.getNickName();
        this.email = signUpRequestDTO.getEmail();
    }
}
