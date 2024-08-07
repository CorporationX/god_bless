package faang.school.godbless.dismantling_amazon_warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = Set.of(
                new Product("Laptop", "Electronics"),
                new Product("Tablet", "Electronics"),
                new Product("Shoes", "Clothing"),
                new Product("T-Shirt", "Clothing"),
                new Product("Sweater", "Clothing"),
                new Product("Sofa", "Furniture"),
                new Product("Chair", "Furniture"),
                new Product("Bed", "Furniture")
        );

        Map<String, List<Product>> categoryMap = groupByCategory(products);
        printProducts(categoryMap);
    }

    public static Map<String, List<Product>> groupByCategory(Set<Product> products) {
        Map<String, List<Product>> categoryMap = new HashMap<>();
        products.forEach(
                product -> categoryMap.computeIfAbsent(
                        product.getCategory(), k -> new ArrayList<>()
                ).add(product)
        );
        return categoryMap;
    }

    public static void printProducts(Map<String, List<Product>> categoryMap) {
        for (Map.Entry<String, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println(entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("\t" + product);

            }
        }
    }
}
