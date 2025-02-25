package ru.ckajiuk.SBISserv.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Сущность товара")
public class Product {
    @Schema(description = "Идентификатор")
    private int id;
    @Schema(description = "Наименование", example = "Кока кола")
    private String name;
    @Schema(description = "Стоимость", example = "100.3")
    private float cost;
    @Schema(description = "Единица измерения", example = "кг")
    private String unit;
    @Schema(description = "Остаток товара", example = "5")
    private int balance;
    @Schema(description = "Ссылка на изображение", example = "http://image.png")
    private String imageurl;
    @Schema(description = "Признак, является ли идентификатор родителем", example = "true")
    private boolean isParent;
}
