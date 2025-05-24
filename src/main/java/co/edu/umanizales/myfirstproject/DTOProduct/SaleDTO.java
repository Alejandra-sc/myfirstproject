package co.edu.umanizales.myfirstproject.DTOProduct;

import co.edu.umanizales.myfirstproject.model.ProductSale;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class SaleDTO {
    private String sellerIdentification;
    private String storeCode;
    private List<ProductSale> productCode;
    private LocalDate saleDate;
    private String code;
    private int quantity;
    private double subtotal;
}
