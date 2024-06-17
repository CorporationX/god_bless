package faang.school.godbless.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Set<Product> PRODUCTS = new HashSet<>();

    public static void main(String[] args) {
        PRODUCTS.addAll(Set.of(
                new Product(1, "HP", "Laptop"),
                new Product(2, "Apple", "Laptop"),
                new Product(3, "Samsung", "TV"),
                new Product(4, "iPhone", "Phone"),
                new Product(5, "Xiaomi", "Phone"),
                new Product(5, "Samsung", "Phone"),
                new Product(5, "LG", "TV"),
                new Product(6, "Bosch", "Dishwasher"),
                new Product(7, "Bosch", "Washing machine")
        ));
        printGroupedProducts(getGroupedProducts());
    }

    public static Map<String, List<Product>> getGroupedProducts() {
        HashMap<String, List<Product>> gropedProducts = new HashMap<>();
        PRODUCTS.forEach(product -> gropedProducts.computeIfAbsent(product.category(), v -> new ArrayList<>()).add(product));
        return gropedProducts;
    }

    public static void printGroupedProducts(Map<String, List<Product>> products) {
        products.forEach((k, v) -> System.out.println("Category: [" + k + "] -- Products: " + v));
    }
}
