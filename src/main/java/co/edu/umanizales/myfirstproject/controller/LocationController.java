package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/location")
public class LocationController {
    @GetMapping
    public String getlocation(){
        Location location = new Location( "563", "Manizales");

        return "Location";

    }
}
