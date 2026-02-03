package com.example.demo.data.entity.singleSchedule;

import com.example.demo.data.entity.user.User;
import com.example.demo.data.enumerate.RepeatType;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SingleSchedule extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    private String scheduleName;

    @Enumerated(EnumType.STRING)
    private RepeatType repeatType;

    private int repeatInterval;

    private LocalDate startDate;
    private LocalDate endDate;

    private LocalTime startTime;
    private LocalTime endTime;

    @OneToMany(mappedBy = "singleSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SingleScheduleWeeklyRule> weeklyRules = new HashSet<>();

    @OneToOne(mappedBy = "singleSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private SingleScheduleMonthlyRule monthlyRule;

    @OneToOne(mappedBy = "singleSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private SingleScheduleYearlyRule yearlyRule;

    @ManyToOne
    @JoinColumn(name = "created_user_id")
    private User user;
}
