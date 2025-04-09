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
        Location medellin = new Location("001", "Medellin");
        Location manizales = new Location("1","Manizales");
        Location  tulua = new Location("834", "Tulua");
        Location buenaventura = new Location("109","Buenaventura");
        Location bogota= new Location("601", "Bogota");

        Seller juan = new Seller("10304569", "Juan David", "Sanchez Perez", medellin, (byte) 42, 'H');
        Seller andres = new Seller("10526787", "Andres felipe", "Lopez Velez", manizales, (byte) 45, 'H');
        Seller sebastian = new Seller("1053808302", "Sebastian", "Murillo Morales", tulua, (byte) 33, 'H');
        Seller manuela = new Seller("1053778156", "Manuela", "Salazar Diaz", buenaventura, (byte) 36, 'M');
        Seller camila = new Seller("1094259761", "Maria camila", "Orozco Rincon", bogota, (byte) 30, 'M');

        return juan;
    }
}