package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Sale;
import co.edu.umanizales.myfirstproject.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/sale")
public class SaleController {
    private List<Sale> sales = new ArrayList<>();

    @GetMapping
    public String getsale() {
        return "sale";
    }
    //mandar solo los codigos de la venta
    // validar que la tienda , vendedor, sean los correctos

    @Autowired
    private SaleService saleService;

    // Agregar una venta
    @PostMapping
    public String addSale(@RequestBody Sale sale) {
        saleService.getSales().add(sale);
        return "Venta agregada correctamente";
    }

    // Filtrar por código de tienda
    @GetMapping("/store/{code}")
    public List<Sale> getSalesByStore(@PathVariable String code) {
        return saleService.filterByStore(code);
    }

    // Filtrar por identificación del vendedor
    @GetMapping("/seller/{id}")
    public List<Sale> getSalesBySeller(@PathVariable String id) {
        return saleService.filterBySeller(id);
    }
}