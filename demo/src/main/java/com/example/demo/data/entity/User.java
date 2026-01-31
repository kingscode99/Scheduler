package com.example.demo.data.entity;

import com.example.demo.data.entity.middle.GroupUser;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "USERS")
public class User extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;

    private String password;

    private String nickname;

    @OneToMany(mappedBy = "user")
    private List<Schedule> scheduleList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<GroupUser> groupUserList = new ArrayList<>();
}
