package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Location;
import co.edu.umanizales.myfirstproject.service.LocationService;
import co.edu.umanizales.myfirstproject.service.locationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

/*
@RestController
@RequestMapping(path = "/location")
public class LocationController {

    @GetMapping
    public Location getLocation() {
        Location location = new Location("17001", "Manizales");


        return location;

    }
}
//Metodo GET para devolver una lista de location
/*@GetMapping
    public List<Location> getlocation() {
    //Aqui estamos creando una lista de ejemplo. Podrias obtener estos datos de una base de datos.

        return Arrays.asList(
                new Location("001", "Location 1"),
                new Location("002", "Location 2"),
                new Location("003", "Location 3")

        );

    }
    */

  /* @Autowired
    private locationService locationService;

    @GetMapping
    public List<Location> getLocations() {
        try {
//Especifica la ruta del archivo CSV
            String csvFilePath = "C:/Users/USUARIO/IdeaProjects/myfirstproject/locations.csv";
            return locationService.readLocationsFromCSV(csvFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;//Manejo simple de la excepcion
        }
    }
*/

@Autowired
private LocationService locationService;

      @GetMapping
      public List<Location> getLocations(){

          return locationService.getLocations();

      }

/*
      @GetMapping(path = "/{code}")
      public Location getLocationByCode(@PathVariable String code){
          return locationService.getLocationByCode(code);

      }

      @GetMapping(path = "/states")
      public List<Location> getLocationsByStates(){
          return locationService.getStates();
      }

  /*
@Autowired
private locationService locationService;

@GetMapping
public List<Location> getLocations() {
    try {
        return locationService.readLocationsFromCSV();
    } catch (IOException | URISyntaxException e) {
        e.printStackTrace();
        return null;//Manejo simple de la excepción
    }
}





