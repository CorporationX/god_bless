package school.faang.task_45171;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<Product> products = new HashSet<>();
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Smartphone", "Electronics"));
        products.add(new Product(3, "Table", "Furniture"));

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);
        printProductsByCategory(groupedProducts);
    }

    public static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.putIfAbsent(product.getCategory(), new ArrayList<>());
            groupedProducts.get(product.getCategory()).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("    " + product);
            }
        }
    }
}
