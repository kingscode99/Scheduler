package com.example.demo.data.entity.groupSchedule.compositePKId;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class GroupScheduleWeeklyRuleId implements Serializable {

    private Long groupScheduleId;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof GroupScheduleWeeklyRuleId groupScheduleWeeklyRuleId)) return false;
        return Objects.equals(groupScheduleId, groupScheduleWeeklyRuleId.groupScheduleId)
                && dayOfWeek == groupScheduleWeeklyRuleId.dayOfWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupScheduleId, dayOfWeek);
    }
}
