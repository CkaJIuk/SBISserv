package ru.ckajiuk.SBISserv.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.ckajiuk.SBISserv.Entities.SalePoint;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SalePointDTO {
    private List<SalePoint> salesPoints;
    private int page;
    private boolean hasMore;
}
