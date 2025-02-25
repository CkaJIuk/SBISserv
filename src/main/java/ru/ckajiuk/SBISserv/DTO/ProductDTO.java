package ru.ckajiuk.SBISserv.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.ckajiuk.SBISserv.Entities.Product;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Объект запроса на получение спсика товаров")
public class ProductDTO {
    @Schema(description = "Список товаров")
    private List<Product> products;
    @Schema(description = "Номер страницы", example = "1")
    private int page;
    @Schema(description = "Флаг наличия других страниц", example = "false")
    private boolean hasMore;
}
