package ru.ckajiuk.SBISserv.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Сущность Прайс-лист")
public class PriceList {
    @Schema(description = "Идентификатор")
    private int id;
    @Schema(description = "Наименование", example = "Новогодние праздники")
    private String name;
}
