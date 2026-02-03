package com.example.demo.data.entity.middle;

import com.example.demo.data.entity.Group;
import com.example.demo.data.entity.user.User;
import com.example.demo.data.enumerate.GroupRole;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
}
