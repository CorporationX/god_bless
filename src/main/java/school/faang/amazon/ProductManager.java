package school.faang.amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A class for managing goods.
 * Allows you to add, delete, search, and display products grouped by category.
 */
@Slf4j
public class ProductManager {
    private final Set<Product> products;
    private final Map<Category, List<Product>> categoryMap;

    public ProductManager() {
        products = new HashSet<>();
        categoryMap = new HashMap<>();
    }

    public void addProduct(Category category, String name) {
        int nextId = 1;

        Product product = new Product(nextId, name, category);

        products.add(product);
        log.debug("The product has been added to the general list. Current number of products: {}", products.size());

        categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    }

    public void removeProduct(Category category, String name) {
        List<Product> productsInCategory = categoryMap.get(category);
        if (productsInCategory != null) {
            productsInCategory.removeIf(product -> product.getName().equals(name));
        }

        products.removeIf(product -> product.getCategory() == category && product.getName().equals(name));
    }

    public void findProductsByCategory(Category category) {
        List<Product> products = categoryMap.get(category);

        if (products == null || products.isEmpty()) {
            log.warn("The category '{}' was not found or does not contain any products.", category);
        } else {
            log.info("Products in the category '{}': ", category);
            for (Product product : products) {
                log.info(product.toString());
            }
        }
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> categoryMap = new HashMap<>(); // Создаем новую карту
        for (Product product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return categoryMap;
    }


    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            Category category = entry.getKey();
            List<Product> products = entry.getValue();

            System.out.println("Products in the category: " + category);

            for (Product product : products) {
                System.out.println("- " + product.getName());
            }
        }
    }
}