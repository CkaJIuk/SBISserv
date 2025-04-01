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
@Document("pricelists")
@Schema(description = "Сущность Прайс-лист")
public class PriceList {
    @Id
    private ObjectId _id;

    @Schema(description = "Идентификатор")
    private Integer id;
    @Schema(description = "Наименование", example = "Новогодние праздники")
    private String name;
}
