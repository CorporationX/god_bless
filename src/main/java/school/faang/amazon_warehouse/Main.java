package school.faang.amazon_warehouse;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        var products = Set.of(
                new Product(1, "IPhone", "Phones"),
                new Product(4, "Samsung", "Phones"),
                new Product(5, "Mouse", "PC"),
                new Product(6, "Monitor", "PC"),
                new Product(8, "RAM", "PC"),
                new Product(3, "Ball", "Sport"),
                new Product(2, "Bar", "Sport")
        );
        printProducts(groupProductsByCategory(products));
    }

    private static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        var groupedProducts = new HashMap<String, List<Product>>();
        for (var product : products) {
            groupedProducts.computeIfAbsent(product.category(), p -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    private static void printProducts(Map<String, List<Product>> products) {
        products.forEach((category, productList) -> System.out.println(category + "\n" + productList + "\n"));
    }
}
