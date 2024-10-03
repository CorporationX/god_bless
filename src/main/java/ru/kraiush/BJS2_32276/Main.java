package ru.kraiush.BJS2_32276;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Set<Product> PRODUCTS = new HashSet<>();

    private static Map<String, List<Product>> groupProducts(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    private static void getGroupedProducts() {
        for (Map.Entry<String, List<Product>> entry: groupProducts(PRODUCTS).entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Product product1 = new Product(1, "Laptop", "Electronics");
        Product product2 = new Product(2, "Body wash", "Cosmetics");
        Product product3 = new Product(3, "Jeans", "Clothes");
        Product product4 = new Product(4, "Dog food", "Pets");
        Product product5 = new Product(5, "Phone", "Electronics");
        Product product6 = new Product(6, "Dress", "Clothes");
        Product product7 = new Product(7, "Shampoo", "Cosmetics");
        Product product8 = new Product(8, "Shirt", "Clothes");
        Product product9 = new Product(9, "Toy duck", "Pets");

        PRODUCTS.add(product1);
        PRODUCTS.add(product2);
        PRODUCTS.add(product3);
        PRODUCTS.add(product4);
        PRODUCTS.add(product5);
        PRODUCTS.add(product6);
        PRODUCTS.add(product7);
        PRODUCTS.add(product8);
        PRODUCTS.add(product9);

        groupProducts(PRODUCTS);
        getGroupedProducts();
    }
}
