package school.faang.Amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static final Set<Product> PRODUCTS = new HashSet<>();

    public static void main(String[] args) {
        PRODUCTS.add(new Product(1, "Smartphone", "Electronics"));
        PRODUCTS.add(new Product(2, "Laptop", "Electronics"));
        PRODUCTS.add(new Product(3, "Chair", "Furniture"));
        PRODUCTS.add(new Product(4, "Table", "Furniture"));
        PRODUCTS.add(new Product(5, "T-shirt", "Clothing"));

        printProductsByCategory();
    }

    public static Map<String, List<Product>> groupProductsByCategory(){
        return PRODUCTS.stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    public static void printProductsByCategory(){
        groupProductsByCategory().forEach((k, v) -> {
            System.out.println("Category: " + k);
            v.forEach(System.out::println);
            System.out.println();
        });
    }
}
