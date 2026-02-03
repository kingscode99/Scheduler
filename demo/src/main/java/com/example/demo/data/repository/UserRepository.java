package com.example.demo.data.repository;

import com.example.demo.data.entity.user.AnonymousUser;
import com.example.demo.data.entity.user.LoginUser;
import com.example.demo.data.entity.user.User;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM AnonymousUser u WHERE u.anonymousId = :anonymousId")
    Optional<AnonymousUser> findByAnonymousId(@Param("anonymousId") String anonymousId);

    @Query("SELECT u FROM LoginUser u WHERE u.email = :email")
    Optional<LoginUser> findByEmail(@Param("email") String email);
}
