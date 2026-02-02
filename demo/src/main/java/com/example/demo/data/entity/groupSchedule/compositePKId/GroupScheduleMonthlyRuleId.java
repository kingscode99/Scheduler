package com.example.demo.data.entity.groupSchedule.compositePKId;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupScheduleMonthlyRuleId implements Serializable {

    private Long groupScheduleId;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof GroupScheduleMonthlyRuleId groupScheduleMonthlyRuleId)) return false;
        return Objects.equals(groupScheduleId, groupScheduleMonthlyRuleId.groupScheduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupScheduleId);
    }
}
