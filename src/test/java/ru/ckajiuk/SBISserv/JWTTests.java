package ru.ckajiuk.SBISserv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.jwt.Jwt;
import ru.ckajiuk.SBISserv.Services.JWTService;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JWTTests {
    @Autowired
    private JWTService jwtService;

    @Test
    void generateTokenTest() {
        Jwt jwt = jwtService.decode(jwtService.generateAccessToken("testuser"));
        assertEquals("testuser", jwt.getSubject());
        assertTrue(jwt.getExpiresAt().isAfter(Instant.now()));
    }
}
