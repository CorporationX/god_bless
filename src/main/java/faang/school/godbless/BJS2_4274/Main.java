package faang.school.godbless.BJS2_4274;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Product> products = Set.of(
                new Product(1L, "Nokia", "Phone"),
                new Product(2L, "Ikea", "Furniture"),
                new Product(3L, "Laptop", "Technic"),
                new Product(4L, "MacBook", "Technic"),
                new Product(5L, "Chair", "Furniture")
        );

        Map<String, List<Product>> sortedProducts = groupByCategory(products);

        printAllProducts(sortedProducts);

    }

    private static Map<String, List<Product>> groupByCategory(Set<Product> products) {
        Map<String, List<Product>> sortedProducts = new HashMap<>();
        for (Product product : products) {
            List<Product> listProduct = sortedProducts.getOrDefault(product.getCategory(), new ArrayList<>());
            listProduct.add(product);
            sortedProducts.put(product.getCategory(), listProduct);
        }
        return sortedProducts;
    }

    private static void printAllProducts(Map<String, List<Product>> products) {
        for (var entry : products.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(entry.getKey() + product.toString());
            }
        }
    }
}
