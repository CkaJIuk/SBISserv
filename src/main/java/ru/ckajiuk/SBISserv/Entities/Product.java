package ru.ckajiuk.SBISserv.Entities;

import com.mongodb.lang.Nullable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Сущность Товар")
public class Product {
    @Schema(description = "Идентификатор в иерархии", example = "32")
    private Integer hierarchicalId;
    @Schema(description = "Идентификатор родителя в иерархии", example = "33")
    private Integer hierarchicalParent;
    @Schema(description = "Внешний идентификатор", example = "c171be53-c651-4102-a4a0-4581946d8a91")
    private String externalId;
    @Schema(description = "Наименование", example = "Кока кола")
    private String name;
    @Schema(description = "Описание товара", example = "Напиток безалкогольный со вкусом вишни")
    private String description;
    @Schema(description = "Стоимость", example = "100.3")
    private Float cost;
    @Schema(description = "Единица измерения", example = "кг")
    private String unit;
    @Schema(description = "Остаток товара", example = "5.8")
    private Float balance;
    @Schema(description = "Ссылка на изображение", example = "http://image.png")
    private String images;
    @Schema(description = "Признак, является ли идентификатор родителем", example = "true")
    private Boolean isParent;
}
