package com.example.demo.data.enumerate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GroupRole {

    MANAGER("MANAGER"),
    REFERRED_USER("REFERRED USER");

    private final String groupRole;
}
