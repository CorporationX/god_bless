package school.faang.bjs_45147;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import school.faang.bjs_45147.exception.CategoryNotFoundException;
import school.faang.bjs_45147.exception.ProductNotFoundException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Log
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Store {
    final Set<Product> products;
    final Set<String> categories;
    final AtomicInteger productCounter;

    public Store() {
        products = new HashSet<>();
        categories = new HashSet<>();
        productCounter = new AtomicInteger();
    }

    public void addItem(String category, String name) {
        validateProductParameters(category, name);
        Product product = new Product(name, category, 0);

        if (!products.contains(product)) {
            int id = productCounter.getAndIncrement();
            product.setId(id);
            products.add(product);
            categories.add(category);
        }
    }

    public void removeItem(String category, String name) throws ProductNotFoundException {
        validateProductParameters(category, name);
        Product product = new Product(name, category, 0);

        if (products.contains(product)) {
            products.remove(product);
        } else {
            throw new ProductNotFoundException();
        }
    }

    public Set<Product> findItemsByCategory(String category) throws CategoryNotFoundException {
        if (!categories.contains(category)) {
            throw new CategoryNotFoundException();
        }

        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toUnmodifiableSet());
    }

    public void printAllItems() {
        log.info(products.toString());
    }

    public Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        products.forEach(product -> {
            String category = product.getCategory();
            List<Product> productsByCategory =
                    groupedProducts.computeIfAbsent(category, k -> new ArrayList<>());

            productsByCategory.add(product);
        });

        return groupedProducts;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.entrySet().forEach(entry -> log.info(entry.toString()));
    }

    private void validateProductParameters(String category, String name) {
        if (category == null || category.isEmpty() || name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
