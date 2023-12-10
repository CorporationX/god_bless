package faang.school.godbless.BJS2_697;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    HashSet<Product> products = new HashSet<>();

    public static void main(String[] args) {
        Product product1 = new Product("Laptop", "Electronics");
        Product product2 = new Product("Toothbrush", "Personal Care");
        Product product3 = new Product("Coffee Maker", "Electronics");
        Product product4 = new Product("Shampoo", "Personal Care");

        // Putting products into a HashSet
        Set<Product> productSet = new HashSet<>(Arrays.asList(product1, product2, product3, product4));

        // Grouping products by category
        Map<String, List<Product>> groupedProducts = groupProductByCategory(productSet);

        // Listing all products by category
        listAllProducts(groupedProducts);
    }

    public static Map<String, List<Product>> groupProductByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void listAllProducts(Map<String, List<Product>> groupedProducts) {
        for (var entry : groupedProducts.entrySet()) {
            System.out.println(entry);
        }
    }
}