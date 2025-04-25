package co.edu.umanizales.myfirstproject.service;


import co.edu.umanizales.myfirstproject.model.Parameter;
import co.edu.umanizales.myfirstproject.model.Product;
import co.edu.umanizales.myfirstproject.model.TypeDocument;
import co.edu.umanizales.myfirstproject.model.TypeProduct;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
@Getter

public class ParameterService {
    private List<Parameter> parameters;

    @PostConstruct
    public void loadParameters() {
        parameters = new ArrayList<>();

        //Leeria los diferentes csv
        parameters.add(new TypeDocument( "CC", "Cedula de ciudadania"));
        parameters.add(new TypeDocument( "NIT", "Numero de identificacion Tributaria"));

        //Type Product
        TypeProduct pcs = new TypeProduct("1", "Computadores");
        parameters.add(pcs);
        parameters.add(new TypeProduct( "2", "Pantallas"));

        parameters.add(new Product("A","MAC", 10000000, 8,pcs));
    }

    public List<Parameter> getParametersByType(int type) {
        List<Parameter> result = new ArrayList<>();
        for (Parameter p : parameters) {
            switch (type) {
                case 1:
                    if (p instanceof TypeDocument) {
                        result.add(p);
                    }
                    break;
                case 2:
                    if (p instanceof TypeProduct) {
                        result.add(p);
                    }
                    break;
                case 3:
                    if (p instanceof Product) {
                        result.add(p);
                    }
                    break;
                case 4:
                default:
                    System.out.println("Tipo no válido.");
                    return result;

            }
        }
        if (result.isEmpty()) {
            System.out.println("No se encontraron elementos del tipo solicitado.");

            }
        return result;
        }


    }






