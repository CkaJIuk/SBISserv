package ru.ckajiuk.SBISserv.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Позиции для заказа")
public class ProductsToOrderDTO {
    @Schema(description = "Идентификатор", example = "1231567")
    private int id;
    @Schema(description = "Количество", example = "3")
    private int count;
    @Schema(description = "Стоимость", example = "15")
    private float cost;
}
