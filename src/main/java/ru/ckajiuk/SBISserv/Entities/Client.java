package ru.ckajiuk.SBISserv.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document("clients")
@Schema(description = "Сущность Клиент")
public class Client {
    @Id
    private ObjectId _id;

    @Schema(description = "Имя клиента", example = "u123456")
    private String clientName;
    @Schema(description = "Ключ доступа", example = "$2a$10$IKOFdQ6sXBDieTb5I6FNJ.JgxJTRxqkJ17IpmtSd9JIu5/JTWkJ7e")
    private String clientSecret;
}
