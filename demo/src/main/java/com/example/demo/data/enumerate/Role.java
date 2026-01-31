package com.example.demo.data.enumerate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {

    MANAGER("manager"),
    REFERRED_USER("referred user");

    private final String role;
}
