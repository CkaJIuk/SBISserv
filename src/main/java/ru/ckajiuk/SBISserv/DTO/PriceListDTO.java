package ru.ckajiuk.SBISserv.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.ckajiuk.SBISserv.Entities.PriceList;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PriceListDTO {
    private List<PriceList> priceLists;
    private int page;
    private boolean hasMore;
}
