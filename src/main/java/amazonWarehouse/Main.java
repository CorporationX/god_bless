package amazonWarehouse;

import java.util.*;

public class Main {
    private static final Set<Product> PRODUCTS = Set.of(
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Tablet", "Electronics"),
            new Product(3, "iPhone", "Electronics"),
            new Product(4, "TV", "Electronics"),
            new Product(5, "Headphones", "Electronics"),
            new Product(6, "Sofa", "Furniture"),
            new Product(7, "Chair", "Furniture"),
            new Product(8, "Desk", "Furniture"),
            new Product(9, "Bed", "Furniture"),
            new Product(10, "Couch", "Furniture")
    );

    public static Map<String, List<Product>> productByCategory(Set<Product> products) {
        Map<String, List<Product>> productByCategory = new HashMap<>();
        products.forEach(product -> {
            productByCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        });
        return productByCategory;
    }

    public static void printProductsByCategory(Set<Product> products) {
        productByCategory(products).forEach((key, value) -> System.out.println(key + " : " + value));
    }


    public static void main(String[] args) {

        printProductsByCategory(PRODUCTS);

    }
}
