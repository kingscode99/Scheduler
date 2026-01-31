package com.example.demo.data.entity;

import com.example.demo.data.entity.middle.GroupUserSchedule;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Schedule extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    private String ScheduleName;

    private byte repeatType;

    private String repeatData;

    //format(yyyy:MM:dd)
    private String startDate;

    private String endDate;

    //format(HH:mm)
    private String startTime;

    private String endTime;

    @ManyToOne
    @JoinColumn(name = "created_user_id")
    private User user;

    @OneToMany(mappedBy = "schedule")
    private List<GroupUserSchedule> GUSList = new ArrayList<>();
}
