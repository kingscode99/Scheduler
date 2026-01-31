package com.example.demo.data.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {

    USER("USER"),
    ADMIN("ADMIN");

    private final String authority;
}
