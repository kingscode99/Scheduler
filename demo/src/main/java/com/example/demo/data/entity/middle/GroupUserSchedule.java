package com.example.demo.data.entity.middle;

import com.example.demo.data.entity.Schedule;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;

@Entity
public class GroupUserSchedule extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gus_id")
    private Long GUSId;

    @ManyToOne
    @JoinColumn(name = "group_user_id")
    private GroupUser groupUser;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
}
