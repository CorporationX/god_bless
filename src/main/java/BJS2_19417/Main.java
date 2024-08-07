package BJS2_19417;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Iphone", "Electronics"));
        products.add(new Product(2, "Vacuum Cleaner", "Electronics"));
        products.add(new Product(3, "Coat", "Clothes"));
        products.add(new Product(4, "Apple", "Food"));

        //Group products by category in HashMap
        System.out.println(groupProducts(products));
        //Get all products by product category
        getAllProducts(products);
    }

    public static Map<String, List<Product>> groupProducts(Set<Product> products) {
        Map<String, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            productMap.computeIfAbsent(product.getCategory(), x -> new ArrayList<>());
            productMap.get(product.getCategory()).add(product);
        }
        return productMap;
    }

    public static void getAllProducts(Set<Product> products) {
        Map<String, List<Product>> productMap = groupProducts(products);
        for (Map.Entry<String, List<Product>> entry : productMap.entrySet()) {
            System.out.println("Товары в категории " + entry.getKey() + " : " + entry.getValue());
        }
    }

}
