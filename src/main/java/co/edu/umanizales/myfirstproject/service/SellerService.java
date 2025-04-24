package co.edu.umanizales.myfirstproject.service;

import co.edu.umanizales.myfirstproject.model.Seller;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SellerService {
    private final LocationService locationService;
    private List<Seller> seller = new ArrayList<>();

    @Value("${sellers_filename}")
    private String sellersfilename;

    public SellerService(LocationService locationService) {
        this.locationService = locationService;
    }


    @PostConstruct
    public void readSellersFromCSV() throws IOException, URISyntaxException {
        seller = new ArrayList<>();
        Path pathFile = Paths.get(getClass().getClassLoader().getResource(sellersfilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);
            // Ciclo para Leer linea por linea y agrega vendedores
            while ((line = csvReader.readNext()) != null) {

                // Crear un nuevo objeto Location y agregarlo a la lista
                seller.add(new Seller(line[2], line[0], line[1], locationService.getLocationByCode(line[3]), Byte.parseByte(line[4]), line[5].charAt(0)));

            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);  // Lanza la excepción para que pueda manejarse en la capa superior si es necesario

        }
    }

    public List<Seller> getAllSellers() {
        return seller;
    }


}

