package ru.ckajiuk.SBISserv.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.ckajiuk.SBISserv.Entities.Product;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
    private List<Product> products;
    private int page;
    private boolean hasMore;
}
