package faang.school.godbless.BJS2_4127;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main (String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Продукт 1", "Категория 1"));
        products.add(new Product(2, "Продукт 2", "Категория 2"));
        products.add(new Product(3, "Продукт 3", "Категория 2"));
        products.add(new Product(4, "Продукт 4", "Категория 3"));
        products.add(new Product(5, "Продукт 5", "Категория 3"));

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);
        printGroupedProducts(groupedProducts);
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> result = new HashMap<>();

        for (Product product : products) {
            result.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        return result;
    }

    public static void printGroupedProducts(Map<String, List<Product>> products) {
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            System.out.printf("Категория: \"%s\"", entry.getKey());
            System.out.println();

            for (Product product : entry.getValue()) {
                System.out.printf("ID: \"%s\", Название: \"%s\"", product.getId(), product.getName());
                System.out.println();
            }
        }
    }
}
