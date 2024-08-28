package faang.school.godbless.BJS2_19488;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Headphones", "Electronics"));
        products.add(new Product(3, "Apples", "Groceries"));
        products.add(new Product(4, "Bananas", "Groceries"));
        products.add(new Product(5, "Shirt", "Clothing"));

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);

        printGroupedProducts(groupedProducts);

    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printGroupedProducts(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("  - " + product);
            }
        }
    }
}
