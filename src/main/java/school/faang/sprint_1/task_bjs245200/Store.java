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
    private final Map<ProductCategory, List<Product>> groupedProducts = new HashMap<>();

    public Product addItem(ProductCategory category, String name) {
        Product product = new Product(name, category);
        warehouse.add(product);
        List<Product> products = groupedProducts.computeIfAbsent(category, key -> new ArrayList<>());
        products.add(product);
        log.info("product {} was added to category {}", name, category);
        return product;
    }

    public void removeItem(ProductCategory category, String name) {
        NameValidator.validateCategoryAndName(category, name);

        Product productForDelete = warehouse.stream()
                .filter(product -> product.getName().equals(name) &&
                        product.getCategory().equals(category))
                .findFirst()
                .orElseThrow(() -> {
                    log.warn("attempted find to delete a non-existent product {} in category {}", name, category);
                    return new NoSuchElementException("No such product");
                });
        warehouse.remove(productForDelete);

        List<Product> products = groupedProducts.get(category);
        products.remove(productForDelete);
        log.info("product {} was deleted from category {}", name, category);
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
        products.forEach(product -> {
            List<Product> tempProductList = grouped.computeIfAbsent(product.getCategory(), key -> new ArrayList<>());
            tempProductList.add(product);
        });
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
}
