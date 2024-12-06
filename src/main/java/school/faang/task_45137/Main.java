package school.faang.task_45137;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashSet<Product> products = new HashSet<>();

        products.add(new Product(1, "Apple", "Fruits"));
        products.add(new Product(2, "Carrot", "Vegetables"));
        products.add(new Product(3, "Banana", "Fruits"));
        products.add(new Product(4, "Broccoli", "Vegetables"));
        products.add(new Product(5, "Milk", "Dairy"));

        printAllItems(products);

        addItem(products, "Beverages", "Orange Juice");

        removeItem(products, "Fruits", "Banana");

        findItemsByCategory(products, "Fruits");

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);

        printProductsByCategory(groupedProducts);
    }

    public static void addItem(HashSet<Product> products, String category, String name) {
        int newId = products.size() + 1;
        Product newProduct = new Product(newId, name, category);
        if (products.add(newProduct)) {
            System.out.println("Product added: " + newProduct);
        } else {
            System.out.println("The product already exists: " + newProduct);
        }
    }

    public static void removeItem(HashSet<Product> products, String category, String name) {
        Product toRemove = products.stream()
                .filter(p -> p.getCategory().equals(category) && p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (toRemove != null) {
            products.remove(toRemove);
            System.out.println("Product removed: " + toRemove);
        } else {
            System.out.println("Product not found in category: " + category);
        }
    }

    public static void findItemsByCategory(HashSet<Product> products, String category) {
        List<Product> items = products.stream()
                .filter(p -> p.getCategory().equals(category))
                .toList();

        if (items.isEmpty()) {
            System.out.println("Category " + category + " not found.");
        } else {
            System.out.println("Products in category " + category + ":");
            items.forEach(System.out::println);
        }
    }

    public static void printAllItems(HashSet<Product> products) {
        System.out.println("List of all products:");
        products.forEach(System.out::println);
    }

    public static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
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
                System.out.println(" - " + product);
            }
        }
    }
}