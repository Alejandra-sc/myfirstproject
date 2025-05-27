package co.edu.umanizales.myfirstproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Sale {
    private Seller seller;
    private Store store;
    private int quantity;
    private List <ProductSale> products;
    private LocalDate dateSale;
    private double totalSale;
}
