package school.faang.sprint_1.task_45109;

import java.util.*;

public class Main {
    static Map<String, List<Product>> productCategories = new HashMap<>();
    static Set<Product> productsSet = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Adding product to data...");
        addItem("Vegetables", "Carrot");
        addItem("Vegetables", "Broccoli");
        addItem("Fruits", "Apple");
        addItem("Fruits", "Banana");
        addItem("Drinks", "Water");
        System.out.println("Printing all products...");
        printAllItems();

        System.out.println("Removing products from data...");
        removeItem("Drinks", "Water");
        removeItem("Fruits", "Apple");
        System.out.println("Printing all products...");
        printAllItems();

        System.out.println("Show products by non-existent category Dairy");
        findItemsByCategory("Dairy");
        System.out.println("Show products by category Vegetables");
        findItemsByCategory("Vegetables");


        productsSet.add(new Product("Apple", "Fruits"));
        productsSet.add(new Product("Carrot", "Vegetables"));
        productsSet.add(new Product("Banana", "Fruits"));
        productsSet.add(new Product("Broccoli", "Vegetables"));
        productsSet.add(new Product("Milk", "Dairy"));

        printProductsByCategory(groupProductsByCategory(productsSet));
    }

    static void addItem(String category, String name) {
        Product product = new Product(name, category);
        productCategories.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
    }

    static void removeItem(String category, String name) {
        List<Product> products = productCategories.get(category);
        if (products != null) {
            products.removeIf(product -> product.getName().contains(name));
            if (products.isEmpty()) {
                productCategories.remove(category);
            }
        }
    }

    static void findItemsByCategory(String category) {
        if (!productCategories.containsKey(category)) {
            System.out.printf("List of products by category %s not founded\n", category);
        } else {
            System.out.println(productCategories.get(category));

        }
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

    static void printAllItems() {
        System.out.println(productCategories);
    }

}
