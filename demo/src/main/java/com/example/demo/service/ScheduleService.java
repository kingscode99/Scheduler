package com.example.demo.service;

import com.example.demo.config.security.UserDetailsImpl;
import com.example.demo.data.dto.requestDTO.SingleScheduleRequestDTO;
import com.example.demo.data.dto.responseDTO.CommonResponseDTO;
import com.example.demo.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;

    public CommonResponseDTO postSingleSchedule(SingleScheduleRequestDTO singleScheduleRequestDTO, UserDetailsImpl userDetails) {

        
        return CommonResponseDTO.builder()
                .message("일정 생성 성공")
                .build();
    }
}
