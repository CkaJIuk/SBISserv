package ru.ckajiuk.SBISserv.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.ckajiuk.SBISserv.DTO.OrderCreateDTO;
import ru.ckajiuk.SBISserv.DTO.ProductsToOrderDTO;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("orders")
@Schema(description = "Сущность Заказ")
public class Order {
    @Id
    private ObjectId _id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Schema(description = "Дата создания заказа", example = "2025-02-20T18:00:15")
    private Date creationDate;
    @Schema(description = "Идентификатор точки продаж", example = "1")
    private int pointId;
    @Schema(description = "Идентификатор Прайс-листа", example = "1")
    private int priceListId;
    @Schema(description = "Имя покупателя", example = "Иванов Иван")
    private String customerName;
    @Schema(description = "Номер телефона покупателя", example = "+7999666666")
    private String customerPhone;
    @Schema(description = "Время поступления заказа", example = "2025-02-20T18:00:15")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date datetime;
    @Schema(description = "Список позиций для заказа")
    private List<ProductsToOrderDTO> Products;
    @Schema(description = "Сумма заказа", example = "123")
    private float totalPrice;
    @Schema(description = "Статус заказа", example = "new/processing/ready/issued/canceled")
    private String status;

    public static Order createFromDTO(OrderCreateDTO DTO) {
        Order order = new Order();
        order.creationDate = Date.from(Instant.now());
        order.pointId = DTO.getPointId();
        order.priceListId = DTO.getPriceListId();
        order.customerName = DTO.getCustomerName();
        order.customerPhone = DTO.getCustomerPhone();
        order.datetime = DTO.getDatetime();
        order.Products = DTO.getProducts();
        float total = 0;
        for (ProductsToOrderDTO p : order.Products) {
            total += p.getCost() * p.getCount();
        }
        order.totalPrice = total;
        order.status = "new";
        return order;
    }
}
