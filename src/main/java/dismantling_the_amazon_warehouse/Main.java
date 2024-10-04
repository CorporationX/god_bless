package dismantling_the_amazon_warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static final Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Car", "Vehicles"));
        products.add(new Product(3, "Tablet", "Electronics"));
        products.add(new Product(4, "Truck", "Vehicles"));

        Map<String, List<Product>> result = groupProductsByCategory(products);
        System.out.println(result);

        printAllProducts(result);
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> result = new HashMap<>();
        for (Product product : products) {
            result.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return result;
    };

    public static void printAllProducts(Map<String, List<Product>> products) {
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            System.out.println("Products: " + entry.getValue());
        }
    }
}
