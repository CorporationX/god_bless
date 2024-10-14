package school.faang.m1s1.bjs2_32290_amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.addAll(List.of(
                new Product("Bread", "Grocery"),
                new Product("Walkman", "Electronics"),
                new Product("Witcher 4", "Games"),
                new Product("iPhone XXX", "Electronics")
        ));
        System.out.println(products);
        System.out.println();

        displayProducts(groupProducts(products));
    }

    private static Map<String, List<Product>> groupProducts(Set<Product> productsSet) {
        Map<String, List<Product>> productsByCategory = new HashMap<>();
        for (Product product : productsSet) {
            productsByCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return productsByCategory;
    }

    private static void displayProducts(Map<String, List<Product>> productsMap) {
        for (var entry : productsMap.entrySet()) {
            String category = entry.getKey();
            System.out.printf("Category: %s | Products: ", category);
            for (Product product : entry.getValue()) {
                int id = product.getId();
                String name = product.getName();
                System.out.printf("\"%s\" (id #%d), ", name, id);
            }
            System.out.println();
        }
    }
}