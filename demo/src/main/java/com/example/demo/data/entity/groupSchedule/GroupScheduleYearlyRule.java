package com.example.demo.data.entity.groupSchedule;

import com.example.demo.data.entity.groupSchedule.compositePKId.GroupScheduleYearlyRuleId;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Month;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupScheduleYearlyRule extends Timestamp {

    @EmbeddedId
    private GroupScheduleYearlyRuleId id;

    @MapsId("groupScheduleId")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private GroupSchedule groupSchedule;

    @Enumerated(EnumType.STRING)
    private Month months;

    @Min(1)
    @Max(31)
    private int dayOfMonth;
}
