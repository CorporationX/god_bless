package faang.school.godbless.amazon;

import java.util.*;

public class Main {
    private static final Set<Product> PRODUCTS = new HashSet<>();

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            String category = product.getCategory();
            groupedProducts.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        }

        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            String category = entry.getKey();
            List<Product> products = entry.getValue();

            System.out.println("Category: " + category);
            for (Product product : products) {
                System.out.println("- " + product.getName() + ": " + product.getCategory());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PRODUCTS.add(new Product(1, "Apple", "Fruit"));
        PRODUCTS.add(new Product(2, "Banana", "Fruit"));
        PRODUCTS.add(new Product(3, "Carrot", "Vegetable"));
        PRODUCTS.add(new Product(4, "Broccoli", "Vegetable"));

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(PRODUCTS);

        printProductsByCategory(groupedProducts);
    }
}

