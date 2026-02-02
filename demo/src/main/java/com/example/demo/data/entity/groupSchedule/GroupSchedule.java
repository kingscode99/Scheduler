package com.example.demo.data.entity.groupSchedule;

import com.example.demo.data.entity.User;
import com.example.demo.data.enumerate.RepeatType;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GroupSchedule extends Timestamp {

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

    @OneToMany(mappedBy = "groupSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GroupScheduleWeeklyRule> weeklyRules = new HashSet<>();

    @OneToOne(mappedBy = "groupSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private GroupScheduleMonthlyRule monthlyRule;

    @OneToOne(mappedBy = "groupSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private GroupScheduleYearlyRule yearlyRule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_user_id")
    private User user;
}
