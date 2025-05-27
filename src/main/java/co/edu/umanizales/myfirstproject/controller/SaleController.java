package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Sale;
import co.edu.umanizales.myfirstproject.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/sale")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    // Ver todas las ventas
    @GetMapping
    public List<Sale> getAllSale() {
        return saleService.getAllSales();
    }

    //Se deben cargar las ventas manualmente desde el postman; ya que no las pude generar por csv,
    // Se coloca a retornar intellij
    // Luego se carga la lista de mis productos que tengo en postman ProductsList
    //Se coloca localhost:8080/load
    //Por ultimo localhost:8080/sale
    @GetMapping("/load")
    public String loadSales() {
        try {
            saleService.readSalesFromCSV();
            return "Sales successfully loaded.";
        } catch (IOException | URISyntaxException e) {
            return "Error loading sales:" + e.getMessage();
        }
    }

    @GetMapping("/seller/{identification}")
    public List<Sale> getSalesBySeller(@PathVariable String identification) {
        return saleService.getSalesBySeller(identification);
    }

    @GetMapping("/store/{code}")
    public List<Sale> getSalesByStore(@PathVariable String code) {
        return saleService.getSalesByStore(code);
    }

    @GetMapping("/date/{date}")
    public List<Sale> getSalesByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return saleService.getSalesByDate(localDate);
    }
}