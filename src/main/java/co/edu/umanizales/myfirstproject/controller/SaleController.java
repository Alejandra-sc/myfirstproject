package co.edu.umanizales.myfirstproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sale")

public class SaleController {
    @GetMapping
    public String getsale(){
        return "Welcome to MyFirst Project";
    }
}
