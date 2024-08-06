package faang.school.godbless.BJS2_19390;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    private static HashSet<Product> products = new HashSet<>();

    private static HashMap<String, List<Product>> groupProductByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> productGroups = new HashMap<>();
        for (Product product : products) {
            productGroups.computeIfAbsent(product.getCategory(), category -> new ArrayList<>()).add(product);
        }
        return productGroups;
    }

    private static void viewAllProductGroupByCategory(HashMap<String, List<Product>> productGroups) {
        for (Map.Entry<String, List<Product>> group : productGroups.entrySet()) {
            System.out.println(group.getKey() + ":");
            group.getValue().forEach(product -> System.out.println(product.getId() + "\t" + product.getName()));
        }
    }

    public static void main(String[] args) {
        products.add(new Product("iPhone 13 Pro", "Smartphone"));
        products.add(new Product("MacBook Pro", "Laptop"));
        products.add(new Product("AirPods Pro", "Wireless Earbuds"));
        products.add(new Product("Samsung Galaxy S21", "Smartphone"));
        products.add(new Product("Dell XPS 13", "Laptop"));
        products.add(new Product("Jabra Elite 85t", "Wireless Earbuds"));
        products.add(new Product("Google Pixel 5", "Smartphone"));
        products.add(new Product("Lenovo ThinkPad X1 Carbon", "Laptop"));
        products.add(new Product("Sony WF-1000XM4", "Wireless Earbuds"));
        products.add(new Product("OnePlus 9 Pro", "Smartphone"));

        HashMap<String, List<Product>> productGroups = groupProductByCategory(products);
        viewAllProductGroupByCategory(productGroups);
    }
}
