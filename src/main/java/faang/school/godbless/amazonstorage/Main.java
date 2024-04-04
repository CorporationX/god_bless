package faang.school.godbless.amazonstorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Set<Product> ALL_PRODUCTS = Set.of(
            new Product("AirForce", "shoe"),
            new Product("AirMax", "shoe"),
            new Product("Adidas T-short", "T-short"),
            new Product("Nike T-short", "T-short")
    );

    private static Map<String, List<Product>> groupedProducts;

    public static void main(String[] args) {
        System.out.println("Test:");
        groupedProducts = getGroupedProductsByCategory(ALL_PRODUCTS);
        printGroupedProducts();

    }

    public static Map<String, List<Product>> getGroupedProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        products.forEach(product -> groupedProducts.computeIfAbsent(product.getCategory(), key -> new ArrayList<>())
                .add(product));
        return groupedProducts;
    }

    public static void printGroupedProducts() {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
