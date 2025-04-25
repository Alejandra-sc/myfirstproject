package co.edu.umanizales.myfirstproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor

public class Sale {
    private Store store;
    private Seller seller;
    private Date dateSale;
    private int gsantity;
    private List products;

}
