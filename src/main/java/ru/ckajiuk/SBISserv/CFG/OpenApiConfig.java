package ru.ckajiuk.SBISserv.CFG;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "SBIS Api",
                description = "API для СБИС \"Для магазинов\"",
                version = "1.0.0",
                contact = @Contact(
                        name = "Sergey K.",
                        email = "skorotkiy@mail.ru"
                )
        )
)

public class OpenApiConfig {
}
