package faang.school.godbless.javaHashMap.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private Set<Product> productSet;

    public Main() {
        productSet = new HashSet<>();

        productSet.add(new Product(1, "Laptop", "Electronics"));
        productSet.add(new Product(2, "T-shirt", "Clothing"));
        productSet.add(new Product(3, "Book", "Literature"));
        productSet.add(new Product(4, "Headphones", "Electronics"));
        productSet.add(new Product(5, "Jeans", "Clothing"));
        productSet.add(new Product(6, "Watch", "Accessories"));
        productSet.add(new Product(7, "Smartphone", "Electronics"));
        productSet.add(new Product(8, "Dress", "Clothing"));
        productSet.add(new Product(9, "Backpack", "Accessories"));
        productSet.add(new Product(10, "Camera", "Electronics"));
    }

    public static void main(String[] args) {
        Main productManager = new Main();

        System.out.println("Product manager check.");

        System.out.println("Product by categories:");
        productManager.printProductsByCategory();
    }


    public Map<String, List<Product>> groupProducts(Set<Product> productSet) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        productSet.forEach(
                product -> groupedProducts.computeIfAbsent(
                        product.getCategory(), key -> new ArrayList<>()
                ).add(product)
        );

        return groupedProducts;
    }

    public void printProductsByCategory() {
        groupProducts(productSet).entrySet().forEach(System.out::println);
    }
}
