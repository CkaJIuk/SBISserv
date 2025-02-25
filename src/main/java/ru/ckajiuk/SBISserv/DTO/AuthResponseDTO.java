package ru.ckajiuk.SBISserv.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Schema(description = "Ответ на запрос авторизации")
public class AuthResponseDTO {
    @Schema(description = "Токен доступа")
    private String accessToken;
    @Schema(description = "Токен для обновления")
    private String refreshToken;
    @Schema(description = "Статус ответа")
    private String status;
}