package ru.ckajiuk.SBISserv.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Объект аутентификации")
public class LoginRequestDTO {
    @Schema(description = "Логин приложения", example = "user")
    private String username;
    @Schema(description = "Пароль в кодировке bcrypt", example = "user")
    private String password;
}
