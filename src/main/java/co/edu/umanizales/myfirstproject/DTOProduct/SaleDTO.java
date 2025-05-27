package co.edu.umanizales.myfirstproject.DTOProduct;

import co.edu.umanizales.myfirstproject.model.ProductSale;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SaleDTO {
        private String seller;
        private String store;
        private List<ProductSale> product;
        private LocalDate saleDate;
    }

