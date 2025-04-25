package co.edu.umanizales.myfirstproject.service;

import co.edu.umanizales.myfirstproject.model.Product;
import co.edu.umanizales.myfirstproject.model.TypeProduct;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter

public class ProductService {
    private final LocationService locationService;
    private List<Product> product = new ArrayList<>();

    @Value("${ListadoComputerProducts.csv}")
    private String computerproductsfilename;

    public ProductService(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostConstruct
    public void readProductFromCSV() throws IOException, URISyntaxException {
        product = new ArrayList<>();
        Path pathFile = Paths.get(getClass().getClassLoader().getResource(computerproductsfilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);
            // Ciclo para Leer linea por linea y agrega tienda
            while ((line = csvReader.readNext()) != null) {

                // Crear un nuevo objeto Location y agregarlo a la lista
                product.add(new Product(line[0], line[1],Double.parseDouble(line[2]),Integer.parseInt(line[3]), new TypeProduct(line[4],line[5])));

            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);  // Lanza la excepción para que pueda manejarse en la capa superior si es necesario

        }
    }

    public List<Product> getAllProducts() {
        return product;
    }


}






