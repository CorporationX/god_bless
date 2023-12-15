package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {

        products.add(new Product( "Pr1", "Cat_A"));
        products.add(new Product( "Pr2", "Cat_A"));
        products.add(new Product( "Pr3", "Cat_B"));
        products.add(new Product( "Pr4", "Cat_C"));
        products.add(new Product( "Pr4", "Cat_C"));

        getProductByCategory(products);
    }

    public static Map<String, List<Product>> sortProduct(Set<Product> products) {
        Map<String, List<Product>> productsByCategory = new HashMap<>();
        for (Product product : products) {
            productsByCategory.putIfAbsent(product.getCategory(), new ArrayList<>());
            productsByCategory.get(product.getCategory()).add(product);
        }
        return productsByCategory;
    }

    public static void getProductByCategory(Set<Product> setProd) {

        Map<String, List<Product>> sortedProdByCat = sortProduct(setProd);
        System.out.println("Info about all products sorted by Category:");

        for (Map.Entry category : sortedProdByCat.entrySet()) {
            System.out.println(category.getKey() + " - " + category.getValue().toString());
        }
    }
}