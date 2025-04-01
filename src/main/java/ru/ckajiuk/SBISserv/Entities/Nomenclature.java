package ru.ckajiuk.SBISserv.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document("nomenclrs")
@Schema(description = "Сущность Номентклатура")
public class Nomenclature {
    @Id
    private ObjectId _id;

    @Schema(description = "Идентификатор точки продаж", example = "170")
    private Integer pointId;
    @Schema(description = "Идентификатор прайс-листа", example = "70")
    private Integer priceListId;
    @Schema(description = "Список товаров")
    List<Product> prods;
}
