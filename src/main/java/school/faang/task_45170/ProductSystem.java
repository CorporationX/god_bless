package school.faang.task_45170;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static school.faang.task_45170.Main.products;

public class ProductSystem {
    private final Map<String, Set<Product>> groupedProducts = new HashMap<>();

    void addItem(int id, String name, String category) {
        Product product = new Product(id, name, category);
        products.add(product);
        groupedProducts.computeIfAbsent(product.getCategory(), k -> new HashSet<>()).add(product);
    }

    public void findItemsByCategory(String category) {
        if (groupedProducts.containsKey(category)) {
            System.out.println("Item category: " + groupedProducts.get(category));
        } else {
            System.out.println("category not found");
        }
    }

    void removeItem(int id, String name, String category) {
        Product product = new Product(id, name, category);
        if (!groupedProducts.containsKey(category)) {
            products.remove(product);
            System.out.println("The product: " + product + " is removed");
        } else {
            System.out.println("The product not found");
        }
    }

    void printAllItems() {
        System.out.println("All products: " + products);
    }

    public static void printProductsByCategory(Map<String, Set<Product>> groupedProducts) {
        for (Map.Entry<String, Set<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("Value: " + product);
            }
        }
    }

    public static Map<String, Set<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, Set<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            productMap.computeIfAbsent(product.getCategory(), k -> new HashSet<>()).add(product);
        }
        return productMap;
    }
}