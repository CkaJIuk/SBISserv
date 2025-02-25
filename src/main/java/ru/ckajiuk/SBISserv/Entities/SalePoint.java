package ru.ckajiuk.SBISserv.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Сущность Точка продаж")
public class SalePoint {
    @Schema(description = "Идентификатор")
    private int id;
    @Schema(description = "Наименование", example = "Алкомаркет")
    private String name;
    @Schema(description = "Номер телефона", example = "+79505555555")
    private String phone;
    @Schema(description = "Адрес", example = "г. Москва, ул. Ходынское роле, 11")
    private String address;
}