package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Location;
import co.edu.umanizales.myfirstproject.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getLocations() {

        return locationService.getLocations();

    }

    @GetMapping(path = "/{code}")
    public Location getLocationByCode(@PathVariable String code) {
        return locationService.getLocationByCode(code);

    }

    @GetMapping(path = "/states")
    public List<Location> getStates() {
        return locationService.getStates();
    }

    @GetMapping(path = "/name/{name}")
    public List<Location> getLocationsByName(@PathVariable String name) {
        return locationService.getLocationsByName(name);

    }

    @GetMapping(path = "/byinitials/{initialLetters}")
    public List<Location> getLocationsByInitialLetters(@PathVariable String initialLetters) {
        return locationService.getLocationsByInitialLetters(initialLetters);
    }


    @GetMapping("/statecode/{stateCode}")
    public List<Location> getLocationsByStateCode(@PathVariable String stateCode) {
        return locationService.getLocationsByStateCode(stateCode);
    }

    @GetMapping("/capitals")
    public List<Location> getCapitals() {
        return locationService.getCapitals();
    }

    @GetMapping(path = "/state/{code}")
    public Location getStateByCode(@PathVariable String code) {
        return locationService.getStateByCode(code);

    }

}

