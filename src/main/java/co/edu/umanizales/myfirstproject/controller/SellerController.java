package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Location;
import co.edu.umanizales.myfirstproject.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/seller")

public class SellerController {
    @GetMapping
    public Seller getseller() {

        //Instanciar 5 sellers

        Seller juan = new Seller("10304569", "Juan David", "Sanchez Perez", new Location( " 369", "Manizales"), (byte) 42, 'H');
        Seller andres = new Seller("10526787", "Andres felipe", "Lopez Velez", new Location("369", "Manizales"), (byte) 45, 'H');
        Seller sebastian = new Seller("1053808302", "Sebastian", "Murillo Morales", new Location("169", "Manizales"), (byte) 33, 'H');
        Seller manuela = new Seller("1053778156", "Manuela", "Salazar Diaz", new Location("635", "Manizales"), (byte) 36, 'M');
        Seller camila = new Seller("1094259761", "Maria camila", "Orozco Rincon", new Location("487", "Manizales"), (byte) 30, 'M');

        return juan;
    }
}