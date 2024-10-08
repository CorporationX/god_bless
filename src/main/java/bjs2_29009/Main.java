package bjs2_29009;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Product> products = Set.of(
                new Product(0, "Fluffy Bear", "Toys"),
                new Product(1, "Some toy", "Toys"),
                new Product(2, "keyboard", "Computer devices"),
                new Product(3, "iPhone 16 Pro Max", "Phones")
                );

        Map<String, List<Product>> categorizedProducts = categorizeProducts(products);
        printCategorizedProducts(categorizedProducts);
    }

    public static Map<String, List<Product>> categorizeProducts(Set<Product> products) {
        Map<String, List<Product>> categorizedProducts = new HashMap<>();

        for (Product product : products) {
            categorizedProducts.computeIfAbsent(product.getCategory(),
                    k -> new ArrayList<Product>()).add(product);
        }
        return categorizedProducts;
    }

    public static void printCategorizedProducts(Map<String, List<Product>> categorizedProducts) {
        for (var entry : categorizedProducts.entrySet()) {
            System.out.printf("Category: %s -> Products: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
