package school.faang.task_45210;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManager {
    private static final Logger logger = LoggerFactory.getLogger(ProductManager.class);

    private final Map<String, List<Product>> productsByCategory = new HashMap<>();

    public Product addItem(String category, String name) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category cannot be null or blank.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null or blank.");
        }

        List<Product> products = productsByCategory.computeIfAbsent(category, k -> new ArrayList<>());
        boolean exists = products.stream().anyMatch(product -> product.getName().equalsIgnoreCase(name));

        if (exists) {
            throw new IllegalArgumentException("Product '" + name + "' already exists in category '" + category + "'.");
        }

        Product product = new Product(name, category);
        products.add(product);
        logger.info("Added product '{}' in category '{}'.", name, category);
        return product;
    }

    public boolean removeItem(String category, String name) {
        List<Product> products = productsByCategory.get(category);
        if (products == null) {
            throw new IllegalArgumentException("Category not found");
        }

        boolean isRemoved = products.removeIf(product -> product.getName().equalsIgnoreCase(name));
        if (!isRemoved) {
            throw new IllegalArgumentException("Product not found in category '" + category + "'.");
        }

        logger.info("Removed product '{}' from category '{}'.", name, category);

        if (products.isEmpty()) {
            productsByCategory.remove(category);
            logger.info("Removed category: {}.", category);
        }

        return true;
    }

    public List<Product> findItemsByCategory(String category) {
        if (!productsByCategory.containsKey(category)) {
            throw new IllegalArgumentException("Category not found");
        }

        logger.info("Finding products by category '{}'.", category);
        return new ArrayList<>(productsByCategory.get(category));
    }

    public void printProducts() {
        productsByCategory.forEach((category, products) -> {
            logger.info("Category '{}': {}", category, products.size());
            products.forEach(product -> logger.info("\tProduct '{}'.", product.getName()));
        });
    }
}