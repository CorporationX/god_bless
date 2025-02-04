package school.faang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A class for managing goods.
 * Allows you to add, delete, search, and display products grouped by category.
 */

public class ProductManager {
    private final Set<Product> products;
    private final Map<Category, List<Product>> categoryMap;

    public ProductManager() {
        products = new HashSet<>();
        categoryMap = new HashMap<>();
    }

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);

        categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    }

    public void removeProduct(Category category, String name) {
        List<Product> productsInCategory = categoryMap.get(category);
        if (productsInCategory != null) {
            productsInCategory.removeIf(product -> product.getName().equals(name));
        }

        products.removeIf(product -> product.getCategory() == category && product.getName().equals(name));
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, Collections.emptyList());
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("  " + product);
            }
        }
    }
}