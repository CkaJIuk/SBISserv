package ru.ckajiuk.SBISserv.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Объект запроса на создание заказа")
public class OrderCreateDTO {
    @Schema(description = "Идентификатор точки продаж", example = "1")
    private int pointId;
    @Schema(description = "Идентификатор Прайс-листа", example = "1")
    private int priceListId;
    @Schema(description = "Имя покупателя", example = "Иванов Иван")
    private String customerName;
    @Schema(description = "Номер телефона покупателя", example = "+7999666666")
    private String customerPhone;
    @Schema(description = "Время заказа", example = "2025-02-20T18:00:15")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date datetime;
    @Schema(description = "Список позиций для заказа")
    private List<ProductsToOrderDTO> Products;

}
