package co.edu.umanizales.myfirstproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Seller {
    private TypeDocument typeDocument;
    private String identification;
    private String name;
    private String lastName;
    private byte age;
    private Location city;
}
