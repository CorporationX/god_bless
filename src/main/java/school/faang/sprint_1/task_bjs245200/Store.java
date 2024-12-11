package school.faang.sprint_1.task_bjs245200;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class Store {
    private final Logger log = LoggerFactory.getLogger(Store.class);
    private final Set<Product> warehouse = new HashSet<>();
    private final Map<ProductCategory, List<Product>> groupedProducts = new HashMap<>();

    public Store() {
        Arrays.stream(ProductCategory.values()).forEach(
                category -> groupedProducts.put(category, new ArrayList<>()));
    }

    public Product addItem(ProductCategory category, String name) {
        Product product = new Product(name, category);
        warehouse.add(product);
        addProductToGroupedMap(groupedProducts, product);
        log.info("product {} was added to category {}", name, category);
        return product;
    }

    public void removeItem(ProductCategory category, String name) {
        NameValidator.validateCategoryAndName(category, name);
        List<Product> productsToDelete = new ArrayList<>();
        List<Product> productsInStore = groupedProducts.get(category);
        productsInStore.forEach(product -> {
            if (Objects.equals(product.getName(), name)
                    && Objects.equals(product.getCategory(), category)) {
                productsToDelete.add(product);
            }
        });

        if (productsToDelete.isEmpty()) {
            log.warn("attempted find to delete a non-existent product {} in category {}", name, category);
            throw new NoSuchElementException("No product " + name + " in category " + category);
        }

        productsToDelete.forEach(product -> {
            productsInStore.remove(product);
            warehouse.remove(product);
            log.info("product id: {} name: {} was deleted from category {}", product.getId(), name, category);
        });
    }

    public List<Product> findItemsByCategory(ProductCategory category) {
        NameValidator.validateCategoryAndName(category);
        return groupedProducts.get(category);
    }

    public void printAllItems() {
        warehouse.forEach(System.out::println);
    }

    public Map<ProductCategory, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<ProductCategory, List<Product>> grouped = new HashMap<>();
        products.forEach(product -> addProductToGroupedMap(grouped, product));
        log.info("Products have been grouped by category");
        return grouped;
    }

    public void printProductsByCategory(Map<ProductCategory, List<Product>> groupedProducts) {
        groupedProducts.forEach((category, products) -> {
            if (products.isEmpty()) {
                System.out.println("No products in this category.");
            }

            System.out.println("Category: " + category);
            products.forEach(System.out::println);
        });
    }

    private void addProductToGroupedMap(Map<ProductCategory, List<Product>> map, Product product) {
        List<Product> products = map.computeIfAbsent(product.getCategory(), key -> new ArrayList<>());
        products.add(product);
    }
}
