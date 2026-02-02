package com.example.demo.data.entity.groupSchedule.compositePKId;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupScheduleYearlyRuleId implements Serializable {

    private Long groupScheduleId;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof GroupScheduleYearlyRuleId groupScheduleYearlyRuleId)) return false;
        return Objects.equals(groupScheduleId, groupScheduleYearlyRuleId.groupScheduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupScheduleId);
    }
}
