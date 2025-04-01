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
import ru.ckajiuk.SBISserv.Entities.Nomenclature;
import ru.ckajiuk.SBISserv.Entities.PriceList;
import ru.ckajiuk.SBISserv.Entities.SalePoint;
import ru.ckajiuk.SBISserv.Repositories.NomenclatureRepo;
import ru.ckajiuk.SBISserv.Repositories.PriceListsRepo;
import ru.ckajiuk.SBISserv.Repositories.SalePointsRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Контроллер для точек продаж", description = "Обрабатывает основные запросы к системе SBIS")
@RequestMapping("/retail")
public class RetailController {

    @Autowired
    private SalePointsRepo salePointsRepo;

    @Autowired
    private PriceListsRepo priceListsRepo;

    @Autowired
    private NomenclatureRepo nomenclatureRepo;

    @GetMapping("/point/list")
    @Operation(summary = "Получить список точек продаж")
    ResponseEntity<SalePointDTO> getPointList(@RequestParam(required = false, name = "product") String product,
                                              @RequestParam(required = false, name = "withPhones", defaultValue = "false") boolean withPhones) {

        List<SalePoint> lst = salePointsRepo.findAll();

        return ResponseEntity.ok(new SalePointDTO(lst, 1, false));
    }

    @GetMapping("/nomenclature/price-list")
    @Operation(summary = "Получить список прайс-листов")
    ResponseEntity<PriceListDTO> getPriceLists(@RequestParam(required = true, name = "pointId") Integer pointId,
                                               @RequestParam(required = true, name = "actualDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                               @RequestParam(required = false, defaultValue = "1", name = "page") Integer page) {

        List<PriceList> lst = priceListsRepo.findAll();
        return ResponseEntity.ok(new PriceListDTO(lst, 1, false));
    }

    @GetMapping("/nomenclature/list")
    @Operation(summary = "Получить список товаров")
    ResponseEntity<ProductDTO> getProducts(@RequestParam(required = true, name = "pointId") Integer pointId,
                                           @RequestParam(required = true, name = "priceListId") Integer priceListId,
                                           @RequestParam(required = false, defaultValue = "1", name = "page") Integer page) {
        Optional<Nomenclature> nom = nomenclatureRepo.findByPointIdAndPriceListId(pointId, priceListId);

        return nom.map(nomenclature -> ResponseEntity.ok(new ProductDTO(nomenclature.getProds(), 1, false)))
                .orElseGet(() -> ResponseEntity.ok(new ProductDTO(null, 1, false)));
    }

    @PostMapping("/order/create")
    @Operation(summary = "Создать заказ")
    ResponseEntity<String> createOrder(@RequestBody OrderCreateDTO order) {
        return ResponseEntity.ok("order created");
    }
}
