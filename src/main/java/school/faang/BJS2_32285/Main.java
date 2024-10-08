package school.faang.BJS2_32285;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Headphone", "Electronics"));
        products.add(new Product(3, "Apple", "Food"));
        products.add(new Product(4, "Orange", "Food"));
        products.add(new Product(5, "Sofa", "Furniture"));
        products.add(new Product(6, "Chair", "Furniture"));

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);

        printGroupedProducts(groupedProducts);
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> productMap = new HashMap<>();

        for (Product product : products) {
            String category = product.getCategory();

            productMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        }

        return productMap;
    }

    public static void printGroupedProducts(Map<String, List<Product>> productMap) {
        for (Map.Entry<String, List<Product>> entry : productMap.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product: entry.getValue()) {
                System.out.println(" " + product);
            }
        }
    }
}
