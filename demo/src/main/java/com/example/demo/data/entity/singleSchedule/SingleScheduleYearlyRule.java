package com.example.demo.data.entity.singleSchedule;

import com.example.demo.data.entity.singleSchedule.compositePKId.SingleScheduleYearlyRuleId;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Month;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SingleScheduleYearlyRule extends Timestamp {

    @EmbeddedId
    private SingleScheduleYearlyRuleId id;

    @MapsId("singleScheduleId")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private SingleSchedule singleSchedule;

    @Enumerated(EnumType.STRING)
    private Month months;

    @Min(1)
    @Max(31)
    private int dayOfMonth;
}
