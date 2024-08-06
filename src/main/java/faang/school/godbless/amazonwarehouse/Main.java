package faang.school.godbless.amazonwarehouse;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Shoes", "Clothes"));
        products.add(new Product(3, "Perfume", "Cosmetics"));
        products.add(new Product(4, "Camera", "Electronics"));
        products.add(new Product(5, "Sofa", "Furniture"));
        products.add(new Product(6, "Jacket", "Clothes"));
        products.add(new Product(7, "Microwave", "Electronics"));
        products.add(new Product(8, "Chair", "Furniture"));
        products.add(new Product(9, "Lipstick", "Cosmetics"));
        products.add(new Product(10, "Bicycle", "Sport"));


        var groupProducts = groupProducts(products);
        showProductsByCategory(groupProducts);
    }

    public static Map<String, List<Product>> groupProducts(Set<Product> productSet) {
        return productSet.stream().collect(groupingBy(Product::getCategory));
    }

    private static void showProductsByCategory(Map<String, List<Product>> products) {
        products.forEach((key, value) -> {
            System.out.println(key);
            value.stream().map(name -> "  " + name.getName()).forEach(System.out::println);
        });
    }
}
