package com.example.demo.data.entity.singleSchedule;

import com.example.demo.data.entity.singleSchedule.compositePKId.SingleScheduleWeeklyRuleId;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SingleScheduleWeeklyRule extends Timestamp {

    @EmbeddedId
    private SingleScheduleWeeklyRuleId id;

    @MapsId("singleScheduleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private SingleSchedule singleSchedule;
}
