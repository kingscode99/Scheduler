package com.example.demo.controller;

import com.example.demo.config.security.UserDetailsImpl;
import com.example.demo.data.dto.requestDTO.SingleScheduleRequestDTO;
import com.example.demo.data.dto.responseDTO.CommonResponseDTO;
import com.example.demo.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    //단일 일정 추가
    @PostMapping("/post/single/schedule")
    public ResponseEntity<CommonResponseDTO> postSingleSchedule(@Valid @RequestBody SingleScheduleRequestDTO singleScheduleRequestDTO,
                                                                @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok(scheduleService.postSingleSchedule(singleScheduleRequestDTO, userDetails));
    }

}
