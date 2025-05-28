package co.edu.umanizales.myfirstproject.service;

import co.edu.umanizales.myfirstproject.model.Parameter;
import co.edu.umanizales.myfirstproject.model.Product;
import co.edu.umanizales.myfirstproject.model.TypeDocument;
import co.edu.umanizales.myfirstproject.model.TypeProduct;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Value;
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
        parameters.add(new TypeDocument("CC", "Cedula de ciudadania"));
        parameters.add(new TypeDocument("NIT", "Numero de identificacion Tributaria"));

        //Type Product
        TypeProduct pcs = new TypeProduct("25697", "Motherboard");
        parameters.add(pcs);
        parameters.add(new TypeProduct("2201", "A"));
        parameters.add(new TypeProduct("2105", "B"));
        parameters.add(new TypeProduct("3345", "C"));
        parameters.add(new TypeProduct("1289", "D"));
        parameters.add(new TypeProduct("2478", "E"));

        parameters.add(new Product("5237", "F", 1490000, 25, pcs));
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

    public Product getProductByCode(String code) {
        for (Parameter p : parameters) {
            if (p.getCode().equals(code)) {
                return (Product) p;
            }
        }

        return null;
    }

    public String addProduct(Product product) {
        //Este valida que ya no exista
        if (getProductByCode(product.getCode()) == null) {
            parameters.add(product);
            return "Product added";//Retorna el producto añadido
        } else {
            return "Product already exists";//Retorna que el producto ya existe
        }
    }

    public String addProducts(List<Product> products) {
        for (Product p : products) {
            String result = addProduct(p);
            if (result.equals("Product already exists")) {
                return "Product already exists" + p.getCode();
            }
        }
        return "Products addeds";
    }

    public TypeProduct getTypeProductByCode(String code) {
        for (Parameter p : parameters) {
            if (p instanceof TypeProduct && p.getCode().equalsIgnoreCase(code)) {
                return (TypeProduct) p;
            }
        }
        return null;
    }

    public TypeDocument getTypeDocumentByCode(String code) {
        for (Parameter p : parameters) {
            if (p instanceof TypeDocument && p.getCode().equalsIgnoreCase(code)) {
                return (TypeDocument) p;
            }
        }
        return null;
    }

}
