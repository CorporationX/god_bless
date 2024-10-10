package Java_HashMap.BJS2_32296;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Product> products = new HashSet<>();

        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Phone", "Electronics"));
        products.add(new Product(3, "Shoes", "Apparel"));
        products.add(new Product(4, "T-Shirt", "Apparel"));

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);

        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("\t" + product);
            }
        }
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> productMap = new HashMap<>();

        for (Product product : products) {
            productMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        return productMap;
    }
}
