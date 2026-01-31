package com.example.demo.data.entity.middle;

import com.example.demo.data.entity.Group;
import com.example.demo.data.entity.User;
import com.example.demo.data.enumerate.GroupRole;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class GroupUser extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupUserId;

    @Enumerated(value = EnumType.STRING)
    private GroupRole groupRole;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "groupUser")
    private List<GroupUserSchedule> GUSList = new ArrayList<>();
}
