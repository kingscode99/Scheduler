package com.example.demo.data.dto.responseDTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AnonymousLoginResponseDTO {
    private String token;
    private String anonymousId;
}
