package com.example.demo.data.entity;

import com.example.demo.data.entity.middle.GroupUser;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "groups")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    private String groupName;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<GroupUser> groupUserList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_user_id")
    private User user;
}
