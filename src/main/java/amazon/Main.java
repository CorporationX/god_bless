package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Set<Product> setProduct = new HashSet<>();

    public static void main(String[] args) {

        setProduct.add(new Product(01, "Pr1", "Cat_A"));
        setProduct.add(new Product(02, "Pr2", "Cat_A"));
        setProduct.add(new Product(03, "Pr3", "Cat_B"));
        setProduct.add(new Product(04, "Pr4", "Cat_C"));
        setProduct.add(new Product(05, "Pr4", "Cat_C"));

        getProdByCat(setProduct);
    }

    public static Map<String, List<Product>> sortProduct(Set<Product> setProd) {
        Map<String, List<Product>> productByCat = new HashMap<>();
        for (Product product : setProd) {
            productByCat.putIfAbsent(product.getCategory(), new ArrayList<>());
            productByCat.get(product.getCategory()).add(product);
        }
        return productByCat;
    }

    public static void getProdByCat(Set<Product> setProd) {

        Map<String, List<Product>> sortedProdByCat = sortProduct(setProd);
        System.out.println("Info about all products sorted by Category:");

        for (Map.Entry category : sortedProdByCat.entrySet()) {
            System.out.println(category.getKey() + " - " + category.getValue().toString());
        }
    }
}