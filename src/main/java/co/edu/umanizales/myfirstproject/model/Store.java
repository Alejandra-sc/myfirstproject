package co.edu.umanizales.myfirstproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.stream.Location;

@Setter
@Getter
@AllArgsConstructor
public class Store {
    private String code;
    private String name;
    private String address;
    private Location city;
}
