package ru.ckajiuk.SBISserv.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ckajiuk.SBISserv.DTO.OrderCreateDTO;
import ru.ckajiuk.SBISserv.DTO.PriceListDTO;
import ru.ckajiuk.SBISserv.DTO.ProductDTO;
import ru.ckajiuk.SBISserv.DTO.SalePointDTO;
import ru.ckajiuk.SBISserv.Entities.PriceList;
import ru.ckajiuk.SBISserv.Entities.Product;
import ru.ckajiuk.SBISserv.Entities.SalePoint;
import ru.ckajiuk.SBISserv.Repositories.MongoRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Tag(name = "Контроллер для точек продаж", description = "Обрабатывает основные запросы к системе SBIS")
@RequestMapping("/retail")
public class RetailController {

    @Autowired
    private MongoRepo mongoRepo;

    @GetMapping("/point/list")
    @Operation(summary = "Получить список точек продаж")
    ResponseEntity<SalePointDTO> getPointList(@RequestParam(required = false, name = "product") String product,
                                              @RequestParam(required = false, name = "withPhones", defaultValue = "false") boolean withPhones) {

        /*List<SalePoint> lst = new ArrayList<>();
        /lst.add(new SalePoint(1, "Добрый", "555-555", "ул. Туполева"));
        /lst.add(new SalePoint(2, "Березка", "333-333", "ул. Антонова"));*/

        List<SalePoint> lst = mongoRepo.findAll();

        return ResponseEntity.ok(new SalePointDTO(lst, 1, false));
    }

    @GetMapping("/nomenclature/price-list")
    @Operation(summary = "Получить список прайс-листов")
    ResponseEntity<PriceListDTO> getPriceLists(@RequestParam(required = true, name = "pointId") Integer pointId,
                                               @RequestParam(required = true, name = "actualDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                               @RequestParam(required = false, defaultValue = "1", name = "page") Integer page) {
        if (pointId == 1) {
            List<PriceList> lst = new ArrayList<>();
            lst.add(new PriceList(1, "Основной прайс-лист"));
            lst.add(new PriceList(2, "Прайс-лист на новогодние"));
            return ResponseEntity.ok(new PriceListDTO(lst, 1, false));
        }
        return ResponseEntity.ok(new PriceListDTO(null, 1, false));
    }

    @GetMapping("/nomenclature/list")
    @Operation(summary = "Получить список товаров")
    ResponseEntity<ProductDTO> getProducts(@RequestParam(required = true, name = "pointId") Integer pointId,
                                           @RequestParam(required = true, name = "priceListId") Integer priceListId,
                                           @RequestParam(required = false, defaultValue = "1", name = "page") Integer page) {
        if (pointId == 1 && priceListId == 1) {
            List<Product> lst = new ArrayList<>();
            lst.add(new Product(1, "Твикс", 55, "р.", 100, "url", false));
            lst.add(new Product(2, "Марс", 57, "р.", 200, "url", false));
            lst.add(new Product(3, "Баунти", 61, "р.", 50, "url", false));
            return ResponseEntity.ok(new ProductDTO(lst, 1, false));
        }
        return ResponseEntity.ok(new ProductDTO(null, 1, false));
    }

    @PostMapping("/order/create")
    @Operation(summary = "Создать заказ")
    ResponseEntity<String> createOrder(@RequestBody OrderCreateDTO order) {
        return ResponseEntity.ok("order created");
    }
}
