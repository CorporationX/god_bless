package faang.school.godbless.javaHashMap.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Set<Product> productSet;

    public static void main(String[] args) {
        productSet = Set.of(new Product(1, "Laptop", "Electronics"),
                new Product(2, "T-shirt", "Clothing"),
                new Product(3, "Book", "Literature"),
                new Product(4, "Headphones", "Electronics"),
                new Product(5, "Jeans", "Clothing"),
                new Product(6, "Watch", "Accessories"),
                new Product(7, "Smartphone", "Electronics"),
                new Product(8, "Dress", "Clothing"),
                new Product(9, "Backpack", "Accessories"),
                new Product(10, "Camera", "Electronics"));


        System.out.println("Product manager check.");

        System.out.println("Product by categories:");
        printProductsByCategory();
    }


    public static Map<String, List<Product>> groupProducts(Set<Product> productSet) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        productSet.forEach(
                product -> groupedProducts.computeIfAbsent(
                        product.getCategory(), key -> new ArrayList<>()
                ).add(product)
        );

        return groupedProducts;
    }

    public static void printProductsByCategory() {
        groupProducts(productSet).entrySet().forEach(System.out::println);
    }
}
