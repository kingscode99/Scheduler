package com.example.demo.data.entity;

import com.example.demo.data.entity.middle.GroupUser;
import com.example.demo.data.entity.singleSchedule.SingleSchedule;
import com.example.demo.data.enumerate.UserRole;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "USERS")
@Getter
public class User extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String nickname;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<SingleSchedule> scheduleList = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<GroupUser> groupUserList = new ArrayList<>();
}
