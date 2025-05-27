package co.edu.umanizales.myfirstproject.service;

import co.edu.umanizales.myfirstproject.model.Seller;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
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
    private List<Seller> seller = new ArrayList<>();

    @Value("${sellers_filename}")
    private String sellersFilename;

    @Autowired
    private LocationService locationService;

    @Autowired
    private ParameterService parameterService;

    public SellerService(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostConstruct
    public void readStoreFromCSV() throws IOException, URISyntaxException {
        seller = new ArrayList<>();
        Path pathFile = Paths.get(getClass().getClassLoader().getResource(sellersFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);
            // Ciclo para Leer linea por linea y agrega vendedor
            while ((line = csvReader.readNext()) != null) {

                // Crear un nuevo objeto vendedor y agregarlo a la lista
                seller.add(new Seller(parameterService.getTypeDocumentByCode(line[0]), line[1], line[2], line[3],
                        Byte.parseByte(line[4]), locationService.getLocationByCode(line[5])));

            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);  // Lanza la excepción para que pueda manejarse en la capa superior si es necesario

        }
    }

    public List<Seller> getAllSellers() {
        return seller;
    }

    public Seller getSellerByIdentification(String identification) {
        for (Seller seller : seller) {
            if (seller.getIdentification().equals(identification))
                return seller;
        }
        return null;
    }
}





