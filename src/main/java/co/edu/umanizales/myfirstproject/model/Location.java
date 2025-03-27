package co.edu.umanizales.myfirstproject.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor

public class Location {
    private String code;
    private String description;


}
