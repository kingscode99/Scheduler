package com.example.demo.config.security;

import com.example.demo.Exception.CustomException;
import com.example.demo.Exception.ErrorCode;
import com.example.demo.data.entity.user.AnonymousUser;
import com.example.demo.data.entity.user.LoginUser;
import com.example.demo.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(@NonNull String id) throws UsernameNotFoundException {
        //id가 이메일 형식일때
        Pattern pattern = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
        if (pattern.matcher(id).matches()) {
            LoginUser user = userRepository.findByEmail(id)
                    .orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_USER));
            return new UserDetailsImpl(user, user.getEmail());
        } else {
            AnonymousUser user = userRepository.findByAnonymousId(id)
                    .orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_USER));
            return new UserDetailsImpl(user, user.getAnonymousId());
        }
    }
}
