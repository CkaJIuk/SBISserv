package ru.ckajiuk.SBISserv.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Обект для отправки refresh token")
public class TokenRequestDTO {
    private String refreshToken;
}
