package school.faang.task_45098;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>(
                Arrays.asList(
                        new Product(UUID.randomUUID().toString(), "Milk", "Food"),
                        new Product(UUID.randomUUID().toString(), "Jacket", "Cloth"),
                        new Product(UUID.randomUUID().toString(), "Cheese", "Food"),
                        new Product(UUID.randomUUID().toString(), "iPhone", "Electronic")
                )
        );
        Warehouse warehouse = new Warehouse(groupProductsByCategory(products));

        warehouse.addItem("Food", "Yogurt");
        warehouse.addItem("Cloth", "T-Shirt");
        warehouse.addItem("Electronic", "Computer");

        warehouse.printAllItems();

        List<Product> itemsByCategory = warehouse.findItemsByCategory("Food");
        System.out.println("Find by category Food: " + itemsByCategory);
        System.out.println();

        warehouse.removeItem("Cloth", "Jacket");
        warehouse.printAllItems();
        System.out.println();

        Map<String, List<Product>> productsByCategory = groupProductsByCategory(warehouse.getProducts());
        System.out.println("Group products by category: " + productsByCategory);
        System.out.println();

        printProductsByCategory(productsByCategory);

    }

    private static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        checkProducts(products);
        Map<String, List<Product>> result = new HashMap<>();
        for (var entry : products) {
            List<Product> productsByCategory = result.getOrDefault(entry.getCategory(), new ArrayList<>());
            productsByCategory.add(entry);
            result.put(entry.getCategory(), productsByCategory);
        }
        return result;
    }

    private static void checkProducts(Set<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("Products don't exist");
        }
    }

    private static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (var entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Products: " + entry.getValue());
        }
    }
}
