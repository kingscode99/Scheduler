package com.example.demo.data.entity.singleSchedule.compositePKId;

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
public class SingleScheduleWeeklyRuleId implements Serializable {

    private Long singleScheduleId;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof SingleScheduleWeeklyRuleId singleScheduleWeeklyRuleId)) return false;
        return Objects.equals(singleScheduleId, singleScheduleWeeklyRuleId.singleScheduleId)
                && dayOfWeek == singleScheduleWeeklyRuleId.dayOfWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hash(singleScheduleId, dayOfWeek);
    }
}
