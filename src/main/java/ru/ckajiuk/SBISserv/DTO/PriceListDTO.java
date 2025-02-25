package ru.ckajiuk.SBISserv.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.ckajiuk.SBISserv.Entities.PriceList;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Объект запроса на получение списка Прайс-листов")
public class PriceListDTO {
    @Schema(description = "Список прайс листов")
    private List<PriceList> priceLists;
    @Schema(description = "Номер страницы", example = "1")
    private int page;
    @Schema(description = "Флаг наличия других страниц", example = "false")
    private boolean hasMore;
}
