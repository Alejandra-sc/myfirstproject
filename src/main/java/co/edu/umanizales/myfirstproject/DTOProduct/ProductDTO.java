package co.edu.umanizales.myfirstproject.DTOProduct;

import lombok.Data;

@Data
public class ProductDTO {
    private String code;
    private String description;
    private double price;
    private int stock;
    private String codeTypeProduct;
}
