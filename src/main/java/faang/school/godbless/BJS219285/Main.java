package faang.school.godbless.BJS219285;

import java.util.*;

public class Main {
    private static Set<Product> products = new HashSet<>();

    public static Map<String, List<Product>> setProducts(Set<Product> products) {
        Map<String, List<Product>> result = new HashMap<>();
        for (Product product : products) {
            result.computeIfAbsent(product.getCategory(), w -> new ArrayList<>()).add(product);
        }
        return result;
    }

    public static void printProducts(Map<String, List<Product>> products) {
        for (Map.Entry<String, List<Product>> productByCategory : products.entrySet()) {
            System.out.println(productByCategory.getKey() + ":");
            productByCategory.getValue().forEach(key -> System.out.println(key.toString()));
        }
    }

    public static void main(String[] args) {
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Smartphone", "Electronics"));
        products.add(new Product(3, "Shirt", "Clothing"));
        products.add(new Product(4, "Pants", "Clothing"));
        products.add(new Product(5, "Blender", "Home Appliances"));

        Map<String, List<Product>> productsByCategory = setProducts(products);

        printProducts(productsByCategory);
    }
}
