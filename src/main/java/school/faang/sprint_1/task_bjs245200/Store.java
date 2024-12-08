package school.faang.sprint_1.task_bjs245200;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Store {
    private final Logger log = LoggerFactory.getLogger(Store.class);
    private final Set<Product> warehouse = new HashSet<>();
    private final Map<String, List<Product>> groupedProducts = new HashMap<>();

    public Product addItem(String category, String name) {
        Product product = new Product(name, category);
        warehouse.add(product);
        List<Product> products = groupedProducts.computeIfAbsent(category, key -> new ArrayList<>());
        products.add(product);
        log.info("product {} was added to category {}", name, category);
        return product;
    }

    public boolean removeItem(String category, String name) {
        checkCategoryExists(category);
        Product product = new Product(name, category);
        boolean removed = warehouse.remove(product);
        if (!removed) {
            log.warn("attempted removal of a non-existent product");
            throw new NoSuchElementException("No such product");
        }
        List<Product> products = groupedProducts.get(category);
        products.remove(product);
        log.info("product {} was deleted from category {}", name, category);
        return true;
    }

    public List<Product> findItemsByCategory(String category) {
        checkCategoryExists(category);
        return groupedProducts.get(category);
    }

    public void printAllItems() {
        warehouse.forEach(System.out::println);
    }

    public Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> grouped = new HashMap<>();
        for (Product product : products) {
            List<Product> tempProductList = grouped.computeIfAbsent(product.getCategory(), key -> new ArrayList<>());
            tempProductList.add(product);
        }
        log.info("Products have been grouped by category");
        return grouped;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.forEach((category, products) -> {
            if (products.isEmpty()) {
                System.out.println("  No products in this category.");
            }

            System.out.println("Category: " + category);
            products.forEach(System.out::println);
        });
    }

    private void checkCategoryExists(String category) {
        if (!groupedProducts.containsKey(category)) {
            log.warn("attempted operation on a non-existent category: {}", category);
            throw new NoSuchElementException("No such category: " + category);
        }
    }
}

