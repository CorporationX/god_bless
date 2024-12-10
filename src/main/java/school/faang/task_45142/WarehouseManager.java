package school.faang.task_45142;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class WarehouseManager {
    private int nextProductId;

    private final Set<Product> products;

    public WarehouseManager() {
        this(new HashSet<>());
    }

    public WarehouseManager(Set<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("Products cannot be null");
        }

        this.nextProductId = getLastProductId(products) + 1;
        this.products = new HashSet<>(products);
    }

    private static int getLastProductId(Set<Product> products) {
        if (products.isEmpty()) {
            return 0;
        }
        int lastProductId = Integer.MIN_VALUE;
        for (Product product : products) {
            lastProductId = Integer.max(lastProductId, product.id());
        }
        return lastProductId;
    }

    private static void validateCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category cannot be null or blank");
        }
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }

    public void addItem(String category, String name) {
        validateCategory(category);
        validateName(name);

        products.add(new Product(nextProductId++, name.trim(), category.trim()));
    }

    public void removeItem(String category, String name) {
        validateCategory(category);
        validateName(name);

        boolean productsRemoved = products.removeIf(product ->
                product.category().equals(category) && product.name().equals(name));

        if (productsRemoved) {
            System.out.printf("All products named %s in %s category have been successfully removed.%n",
                    name, category);
        } else {
            System.out.printf("No product found with name %s in category %s.%n", name, category);
        }
    }

    public void findItemsByCategory(String category) {
        validateCategory(category);

        boolean productsFound = false;
        System.out.printf("%s:%n", category);
        for (Product product : products) {
            if (product.category().equals(category)) {
                System.out.printf("\t- %s%n", product);
                productsFound = true;
            }
        }
        if (!productsFound) {
            System.out.println("\tNo products found in this category.");
        }
    }

    private Map<String, List<Product>> groupProductsByCategory() {
        Map<String, List<Product>> productsByCategory = new HashMap<>();
        for (Product product : products) {
            productsByCategory.computeIfAbsent(product.category(), k -> new ArrayList<>()).add(product);
        }
        return productsByCategory;
    }

    public void printProductsByCategory() {
        Map<String, List<Product>> groupedProducts = groupProductsByCategory();
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.printf("Category: %s%n", entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.printf("\t- %s%n", product);
            }
        }
    }

    public void printAllItems() {
        products.forEach(System.out::println);
    }
}
