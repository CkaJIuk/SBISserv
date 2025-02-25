package ru.ckajiuk.SBISserv.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Schema(description = "Ответ на запрос авторизации")
public class AuthResponseDTO {
    private String accessToken;
    private String refreshToken;
    private String status;
}