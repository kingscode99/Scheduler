package com.example.demo.data.entity.singleSchedule;

import com.example.demo.data.entity.singleSchedule.compositePKId.SingleScheduleMonthlyRuleId;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SingleScheduleMonthlyRule extends Timestamp {

    @EmbeddedId
    private SingleScheduleMonthlyRuleId id;

    @MapsId("singleScheduleId")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private SingleSchedule singleSchedule;

    @Min(1)
    @Max(31)
    private int dayOfMoth;
}
