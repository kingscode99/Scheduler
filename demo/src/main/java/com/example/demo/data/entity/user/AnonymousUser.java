package com.example.demo.data.entity.user;

import com.example.demo.data.enumerate.UserRole;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("ANONYMOUS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AnonymousUser extends User {

    private String anonymousId;

    public AnonymousUser(String anonymousId) {
        super(UserRole.ANONYMOUS);
        this.anonymousId = anonymousId;
    }
}
