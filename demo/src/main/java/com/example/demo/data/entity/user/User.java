package com.example.demo.data.entity.user;

import com.example.demo.data.entity.middle.GroupUser;
import com.example.demo.data.entity.singleSchedule.SingleSchedule;
import com.example.demo.data.enumerate.UserRole;
import com.example.demo.data.timestamp.Timestamp;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "USERS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class User extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @LastModifiedDate
    private LocalDateTime lastAccessedAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<SingleSchedule> scheduleList = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<GroupUser> groupUserList = new ArrayList<>();

    protected User(UserRole userRole) {
        this.userRole = userRole;
    }
}
