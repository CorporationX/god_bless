package school.faang.s13task45124;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Getter
public class WarehouseManagement {
    private final Set<Product> products = new HashSet<>();
    private final Map<String, List<Product>> groupedProducts = new HashMap<>();

    public void addItem(String category, String name) {
        validateProductItem(category);
        validateProductItem(name);

        Product product = new Product(category, name);
        products.add(product);
        log.info("product have added to the Set");

        groupedProducts.computeIfAbsent(category, c -> new ArrayList<>()).add(product);
        log.info("product have added to the Map");
    }

    public void findItemsByCategory(String category) {
        validateProductItem(category);

        groupedProducts.getOrDefault(category, List.of());
        if (!groupedProducts.containsKey(category)) {
            log.warn("сategory '{}' have not found", category);
        } else {
            log.info("products by category have found");
        }
    }

    public void removeItem(String category, String name) {
        validateProductItem(category);
        validateProductItem(name);

        products.removeIf(product -> product.getName().equals(name) && product.getCategory().equals(category));
        if (!groupedProducts.containsKey(category)) {
            log.warn("сategory '{}' have not found", category);
        } else {
            log.info("product have removed");
        }
    }

    public void printAllItems() {
        products.forEach(product ->
                log.info("{}: {}", product.getCategory(), product.getName()));
    }

    protected void validateProductItem(String productItem) {
        if (productItem == null || productItem.isEmpty()) {
            throw new IllegalArgumentException("product item cannot be null or empty");
        }
    }

    public Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.forEach((category, products) -> {
            if (!products.isEmpty()) {
                log.info("Category: {}", category);
                products.forEach(product -> log.info("  {}", product));
            }
        });
    }
}