package ru.ckajiuk.SBISserv.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JWTService {
    @Autowired
    private JwtEncoder encoder;

    @Autowired
    private JwtDecoder decoder;

    private String generateToken(String username, long expired_seconds) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expired_seconds))
                .subject(username)
                .build();
        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public String generateAccessToken(String username) {
        return generateToken(username, 300);
    }

    public String generateRefreshToken(String username) { return generateToken(username, 86400); }

    public String getNewAccessToken(String token) {
        try {
            Jwt jwt = decoder.decode(token);
            if (jwt.getExpiresAt().isAfter(Instant.now())) {
                return generateAccessToken(jwt.getSubject());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}