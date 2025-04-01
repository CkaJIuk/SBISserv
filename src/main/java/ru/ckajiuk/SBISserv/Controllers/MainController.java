package ru.ckajiuk.SBISserv.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ckajiuk.SBISserv.DTO.AuthResponseDTO;
import ru.ckajiuk.SBISserv.DTO.LoginRequestDTO;
import ru.ckajiuk.SBISserv.DTO.TokenRequestDTO;
import ru.ckajiuk.SBISserv.Services.AuthService;
import ru.ckajiuk.SBISserv.Services.JWTService;

@RestController
@Tag(name = "Контроллер аутентификации", description = "Выполняет аутентификацию приложения, позволяет получить токены доступа")
public class MainController {
    @Autowired
    private AuthService authService;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/auth/login")
    @Operation(summary = "Авторизация")
    ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request) {
        if (authService.verifyPassword(request.getClientName(), request.getClientSecret())) {
            String accessToken = jwtService.generateAccessToken(request.getClientName());
            String refreshToken = jwtService.generateRefreshToken(request.getClientSecret());
            return ResponseEntity.ok(new AuthResponseDTO(accessToken, refreshToken, "ok"));
        } else return ResponseEntity.ok(new AuthResponseDTO("", "", "invalid login/password"));
    }

    @PostMapping("/auth/token")
    @Operation(summary = "Обновить Access Token")
    ResponseEntity<AuthResponseDTO> token(@RequestBody TokenRequestDTO request) {
        String newtoken = jwtService.getNewAccessToken(request.getRefreshToken());
        if (newtoken != null) return ResponseEntity.ok(new AuthResponseDTO(newtoken, "", "ok"));
        else return ResponseEntity.ok(new AuthResponseDTO("", "", "invalid refresh token"));
    }
}

