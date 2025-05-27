package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Seller;
import co.edu.umanizales.myfirstproject.service.SaleService;
import co.edu.umanizales.myfirstproject.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(path = "/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Seller> getAllSeller() {
        return sellerService.getAllSellers();
    }

    @GetMapping(path = "id/{identification}")
    public Seller getSellerByIdentification(@PathVariable String identification) {
        return sellerService.getSellerByIdentification(identification);
    }
}