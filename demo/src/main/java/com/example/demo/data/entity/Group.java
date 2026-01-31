package com.example.demo.data.entity;

import com.example.demo.data.entity.middle.GroupUser;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "GROUPS")
public class Group extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    private String groupName;

    @OneToMany(mappedBy = "group")
    private List<GroupUser> groupUserList;
}
