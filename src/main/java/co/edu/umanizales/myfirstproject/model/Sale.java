package co.edu.umanizales.myfirstproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor

public class Sale {
    private String product;
    private int input;
    private int output;
    private Date dateSale;
    private Date returnDate;
    private String customer;
    private String formPayment;
    private String state;
    private int salesId;

}
