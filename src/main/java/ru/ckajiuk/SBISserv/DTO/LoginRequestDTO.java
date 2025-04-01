package ru.ckajiuk.SBISserv.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Объект аутентификации")
public class LoginRequestDTO {
    @Schema(description = "Имя клиента", example = "u123456")
    private String clientName;
    @Schema(description = "Ключ доступа в кодировке bcrypt", example = "$2a$10$IKOFdQ6sXBDieTb5I6FNJ.JgxJTRxqkJ17IpmtSd9JIu5/JTWkJ7e")
    private String clientSecret;
}