package co.edu.umanizales.myfirstproject.service;

import co.edu.umanizales.myfirstproject.model.Location;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class locationService {

    public List<Location> readLocationsFromCSV(String csvFilePath) throws IOException {
        List<Location> locations = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;
            //Leer todas las filas del CSV
            while ((line = csvReader.readNext()) != null) {
                //Suponemos que el CSV tiene dos columnas: code y descripcion
                String code = line[0];
                String description = line[1];
                //Crear un nuevo objeto Location y arregarlo a la lista
                locations.add(new Location(code, description));
//                locations.add(location);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;  //Lanza la excepcion para que pueda manejarse en la capa superior si es necesario
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return locations;
    }
}


