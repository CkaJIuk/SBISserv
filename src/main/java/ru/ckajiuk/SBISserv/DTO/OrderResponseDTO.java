package ru.ckajiuk.SBISserv.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Schema(description = "Ответ на создание заказа")
public class OrderResponseDTO {
    @Schema(description = "Статус ответа")
    private String status;
    @Schema(description = "Номер заказа")
    private String orderId;
    @Schema(description = "Дата заказа")
    private Date creationDate;
    @Schema(description = "Стоимость заказа")
    private float totalPrice;
}
