package com.example.demo.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UuidMaker {

    public static String createUuid() {
        return UUID.randomUUID().toString();
    }
}
