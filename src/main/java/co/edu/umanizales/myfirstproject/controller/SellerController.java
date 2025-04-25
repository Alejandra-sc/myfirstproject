package co.edu.umanizales.myfirstproject.controller;


import co.edu.umanizales.myfirstproject.model.Seller;

import co.edu.umanizales.myfirstproject.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public List<Seller> getAllSeller() {
        return sellerService.getAllSellers();
    }


}






