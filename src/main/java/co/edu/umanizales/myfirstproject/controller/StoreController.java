package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Store;
import co.edu.umanizales.myfirstproject.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getAllStore() {
        return storeService.getAllStores();
    }

    @GetMapping(path = "/{code}")
    public Store getStoreByCode(@PathVariable String code) {
        return storeService.getStoreByCode(code);
    }
}




