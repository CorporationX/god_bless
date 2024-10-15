package school.faang.firstStream.BJS2_32287;

import java.util.*;

public class Main {
    private static final Set<Product> products = new HashSet<>();

    public static Map<String, List<Product>> groupByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            String category = product.getCategory();

            groupedProducts.computeIfAbsent(category, value -> new ArrayList<>()).add(product);
        }

        return groupedProducts;
    }

    public static void getAllProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (var entry : groupedProducts.entrySet()) {
            System.out.printf("Категория: %s%n", entry.getKey());
            entry.getValue().forEach(product -> System.out.println(product.getName()));
        }
    }

    public static void main(String[] args) {
        products.add(new Product(1, "Refrigerator", "Electronics"));
        products.add(new Product(2, "Teapot", "Electronics"));
        products.add(new Product(3, "Pants", "Clothing"));
        products.add(new Product(3, "T-shirt", "Clothing"));

        getAllProductsByCategory(groupByCategory(products));
    }
}
