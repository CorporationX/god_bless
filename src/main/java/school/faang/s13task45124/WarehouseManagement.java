package school.faang.s13task45124;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Getter
public class WarehouseManagement {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> groupedProducts = new HashMap<>();

    public void addItem(Category category, String name) {
        Product product = new Product(category, name);
        products.add(product);
        log.info("Added product with id {}", product.getId());

        List<Product> productList = groupedProducts.computeIfAbsent(category, c -> new ArrayList<>());
        productList.add(product);
        log.info("Added product with id {} to the category {} in the Map", product.getId(), category);
    }

    public List<Product> findItemsByCategory(Category category) {
        List<Product> products = groupedProducts.getOrDefault(category, Collections.emptyList());
        if (products == null) {
            throw new IllegalArgumentException("Category " + category + " does not exist");
        }
        if (products.isEmpty()) {
            log.warn("Category {} has not found", category);
        } else {
            log.info("Products by category {} have been found", category);
        }
        return products;
    }

    public void removeItem(Category category, String name) {
        products.removeIf(product -> Objects.equals(product.getName(), name)
                && Objects.equals(product.getCategory(), category));
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


    public Map<Category, List<Product>> groupProductsByCategory(Set<Product> products) {
        for (Product product : products) {
            List<Product> productList = groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>());
            productList.add(product);
        }
        return groupedProducts;
    }

    public void printProductsByCategory(Map<Category, List<Product>> groupedProducts) {
        groupedProducts.forEach((category, products) -> {
            if (!products.isEmpty()) {
                log.info(" {}", category);
                products.forEach(product -> log.info("  {}", product));
            }
        });
    }
}