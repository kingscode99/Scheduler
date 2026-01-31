package com.example.demo.data.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class CommonResponseDTO {

    private String message;

    private Object body;
}
