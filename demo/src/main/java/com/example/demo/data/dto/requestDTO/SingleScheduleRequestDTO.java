package com.example.demo.data.dto.requestDTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
public class SingleScheduleRequestDTO {

    @NotEmpty(message = "일정 이름을 입력해 주세요")
    private String scheduleName;

    private byte repeatType;

    private String repeatData;

    @DateTimeFormat(pattern = "yyyy:MM:dd")
    private String startDate;

    @DateTimeFormat(pattern = "yyyy:MM:dd")
    private String endDate;

    @DateTimeFormat(pattern = "HH:mm")
    private String startTime;

    @DateTimeFormat(pattern = "HH:mm")
    private String endTime;
}
