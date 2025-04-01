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
@Document("points")
@Schema(description = "Сущность Точка продаж")
public class SalePoint {
    @Id
    private ObjectId _id;

    @Schema(description = "Идентификатор")
    private Integer id;
    @Schema(description = "Наименование", example = "Алкомаркет")
    private String name;
    @Schema(description = "Номер телефона", example = "+79505555555")
    private String phone;
    @Schema(description = "Адрес", example = "г. Москва, ул. Ходынское поле, 11")
    private String address;
}