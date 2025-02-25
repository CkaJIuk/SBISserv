package ru.ckajiuk.SBISserv.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.ckajiuk.SBISserv.Entities.SalePoint;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Объект запроса на получение списка точек продаж")
public class SalePointDTO {
    @Schema(description = "Точки продаж")
    private List<SalePoint> salesPoints;
    @Schema(description = "Номер страницы", example = "1")
    private int page;
    @Schema(description = "Флаг наличия других страниц", example = "false")
    private boolean hasMore;
}
