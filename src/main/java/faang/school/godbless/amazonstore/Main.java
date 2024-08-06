package faang.school.godbless.amazonstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Apple", "Fruit"));
        products.add(new Product(2, "Banana", "Fruit"));
        products.add(new Product(3, "Carrot", "Vegetable"));
        products.add(new Product(4, "Broccoli", "Vegetable"));
        products.add(new Product(5, "Chicken", "Meat"));
        products.add(new Product(6, "Beef", "Meat"));

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);
        printGroupedProducts(groupedProducts);
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            productMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return productMap;
    }

    public static void printGroupedProducts(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("  " + product);
            }
        }
    }
}
