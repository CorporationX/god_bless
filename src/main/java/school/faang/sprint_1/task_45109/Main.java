package school.faang.sprint_1.task_45109;

import java.util.*;

public class Main {
    static Set<Product> productsSet = new HashSet<>();

    public static void main(String[] args) {
        Product product = new Product();

        System.out.println("Adding product to data...");
        product.addItem("Vegetables", "Carrot");
        product.addItem("Vegetables", "Broccoli");
        product.addItem("Fruits", "Apple");
        product.addItem("Fruits", "Banana");
        product.addItem("Drinks", "Water");
        System.out.println("Printing all products...");
        product.printAllItems();

        System.out.println("Removing products from data...");
        product.removeItem("Drinks", "Water");
        product.removeItem("Fruits", "Apple");
        System.out.println("Printing all products...");
        product.printAllItems();

        System.out.println("Show products by non-existent category Dairy");
        product.findItemsByCategory("Dairy");
        System.out.println("Show products by category Vegetables");
        product.findItemsByCategory("Vegetables");


        productsSet.add(new Product(1, "Apple", "Fruits"));
        productsSet.add(new Product(2, "Carrot", "Vegetables"));
        productsSet.add(new Product(3, "Banana", "Fruits"));
        productsSet.add(new Product(4, "Broccoli", "Vegetables"));
        productsSet.add(new Product(5, "Milk", "Dairy"));

        printProductsByCategory(groupProductsByCategory(productsSet));

    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            productMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return productMap;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("  - " + product);
            }
        }
    }

}
