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

    @GetMapping(path = "/{states}")
    public List<Location> getLocationByStates(@PathVariable String states) {
        return locationService.getStates();
    }

    @GetMapping(path = "/{name}")
    public Location getLocationByName(@PathVariable String name) {
        return locationService.getLocationByName(name);

    }

    @GetMapping(path = "/{InitialLetters}")
    public List<Location> getLocationByLetters(@PathVariable String InitialLetters) {
        return locationService.getLocationByLetters(InitialLetters);
    }


    @GetMapping("/StateCode/{stateCode}")
    public List<Location> getLocationByStateCode(@PathVariable String stateCode) {
        return locationService.getLocationByStateCode(stateCode);
    }

    @GetMapping("/{capitals}")
    public List<Location> getLocationByCapitals(@PathVariable String capitals) {
        return locationService.getLocationByCapitals(capitals);
    }

}

