package faang.school.godbless.bjs2_4339;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(1L, "Apple C1", "Computers"));
        products.add(new Product(2L, "Toshiba T800", "Computers"));
        products.add(new Product(3L, "Table T1", "Furniture"));
        products.add(new Product(4L, "Chair IKEA CH3", "Furniture"));
        products.add(new Product(5L, "Dark Souls DVD", "Games"));

        printProductsByCategory(groupProductsByCategory(products));
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> categoryProductsMap = new HashMap<>();
        for (Product product : products) {
            categoryProductsMap.computeIfAbsent(product.getCategory(), key -> new ArrayList<>()).add(product);
        }
        return categoryProductsMap;
    }

    public static void printProductsByCategory(Map<String, List<Product>> categoryProductsMap) {
        for (Map.Entry<String, List<Product>> entry : categoryProductsMap.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
