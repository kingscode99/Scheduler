package com.example.demo.data.entity.groupSchedule;

import com.example.demo.data.entity.groupSchedule.compositePKId.GroupScheduleMonthlyRuleId;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupScheduleMonthlyRule extends Timestamp {

    @EmbeddedId
    private GroupScheduleMonthlyRuleId id;

    @MapsId("groupScheduleId")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private GroupSchedule groupSchedule;

    @Min(1)
    @Max(31)
    private int dayOfMoth;
}
