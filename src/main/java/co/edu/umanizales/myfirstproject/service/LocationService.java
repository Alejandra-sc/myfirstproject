package co.edu.umanizales.myfirstproject.service;

import co.edu.umanizales.myfirstproject.model.Location;
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
public class LocationService {

    private List<Location> locations;

    @Value("${locations_filename}")
    private String locationsFilename;

    @PostConstruct
    public void readLocationsFromCSV() throws IOException, URISyntaxException {
        locations = new ArrayList<>();

        Path pathFile = Paths.get(ClassLoader.getSystemResource(locationsFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);
            // Ciclo para Leer todas las filas del CSV
            while ((line = csvReader.readNext()) != null) {

                // Crear un nuevo objeto Location y agregarlo a la lista
                locations.add(new Location(line[0].trim(), line[1].trim()));

            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;  // Lanza la excepción para que pueda manejarse en la capa superior si es necesario
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
//Ciclo para retornar un codigo
    public Location getLocationByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }
//ciclo para retornar estados
    public List<Location> getStates() {
        List<Location> states = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCode().length() == 2) {
                states.add(location);
            }
        }
        return states;
    }

    public List<Location> getLocationsByName(String name) {
        List<Location> result = new ArrayList<>();
        for (Location location : locations) {
            if (location.getDescription().startsWith(name)) {
                result.add(location);
            }
        }
        return result;
    }
//Ciclo para retornar las iniciales de las letras de ciertos codigos
    public List<Location> getLocationsByInitialLetters(String letters) {
        List<Location> result = new ArrayList<>();
        for (Location location : locations) {
            if (location.getDescription().startsWith(letters)) {
                result.add(location);
            }
        }
        return result;
    }
//Ciclo para retornar las ubicaciones por codigo del departamento
    public List<Location> getLocationsByStateCode(String stateCode) {
        List<Location> statesCode = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCode().startsWith(stateCode)) {
                statesCode.add(location);
            }

        }
        return statesCode;
    }
//Ciclo para retornar capitales
public List<Location> getCapitals() {
        List<Location> result = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCode().endsWith("01") && location.getCode().length() == 5) {
                result.add(location);
            }
        }
        return result;

        }

    //Ciclo para retornar el departamento del codigo dado que tenga solo dos caracteres
    public Location getStateByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code) && location.getCode().length() == 2) {
                return location;
            }
        }
        return null;
    }


}





