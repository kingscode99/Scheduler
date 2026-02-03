package com.example.demo.config.jwt;

import com.example.demo.config.security.UserDetailsImpl;
import com.example.demo.config.security.UserDetailsServiceImpl;
import com.example.demo.data.enumerate.UserRole;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final UserDetailsServiceImpl userDetailsService;
    public static final String AUTHORIZATION_KEY = "auth";
    public static final String BEARER_PREFIX = "bearer";

    @Value("${jwt.secret.key}")
    private String secretKey;
    private SecretKey key;

    @PostConstruct
    public void init() {
        byte[] bytes = Base64.getDecoder().decode(secretKey);
        key = Keys.hmacShaKeyFor(bytes);
    }

    public String createToken(String id, UserRole role) {
        Date date = new Date();

        return BEARER_PREFIX + " " +
                Jwts.builder()
                        .subject(id)
                        .expiration(new Date(date.getTime() + 60 * 60 * 1000L))
                        .claim(AUTHORIZATION_KEY, role)
                        .issuedAt(date)
                        .signWith(key)
                        .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            log.info("유효하지 않은 JWT token 입니다.");
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT token 입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원 되지 않는 JWT token 입니다.");
        } catch (IllegalArgumentException e) {
            log.info("잘못된 JWT token 입니다.");
        }
        return false;
    }

    public Claims getUserInfoFromToken(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }

    public Authentication createAuthentication(String id) {
        UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(id);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest request) {
        String bearToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(bearToken) && bearToken.startsWith(BEARER_PREFIX)) {
            return bearToken.substring(7);
        }
        return null;
    }
}
