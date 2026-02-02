package com.example.demo.data.entity.singleSchedule.compositePKId;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SingleScheduleMonthlyRuleId implements Serializable {

    private Long singleScheduleId;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof SingleScheduleMonthlyRuleId singleScheduleMonthlyRuleId)) return false;
        return Objects.equals(singleScheduleId, singleScheduleMonthlyRuleId.singleScheduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(singleScheduleId);
    }
}
