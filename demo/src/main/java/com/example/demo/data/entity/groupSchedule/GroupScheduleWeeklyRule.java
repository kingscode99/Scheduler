package com.example.demo.data.entity.groupSchedule;

import com.example.demo.data.entity.groupSchedule.compositePKId.GroupScheduleWeeklyRuleId;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class GroupScheduleWeeklyRule extends Timestamp {

    @EmbeddedId
    private GroupScheduleWeeklyRuleId id;

    @MapsId("groupScheduleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private GroupSchedule groupSchedule;
}
