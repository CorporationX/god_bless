package school.faang.sprint_1.task_bjs245200;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
        List<Product> productsInStore = findItemsByCategory(category);

        Iterator<Product> productsIterator = productsInStore.iterator();
        boolean removed = false;
        while (productsIterator.hasNext()) {
            Product product = productsIterator.next();
            if (Objects.equals(product.getName(), name)) {
                productsIterator.remove();
                warehouse.remove(product);
                removed = true;
                log.info("product id: {} name: {} was deleted from category {}", product.getId(), name, category);
            }
        }

        if (!removed) {
            log.warn("attempted find to delete a non-existent product {} in category {}", name, category);
            throw new NoSuchElementException("No product " + name + " in category " + category);
        }
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
            System.out.println("Category: " + category);

            if (products.isEmpty()) {
                System.out.println("No products in this category.");
            }
            products.forEach(System.out::println);
        });
    }

    private void addProductToGroupedMap(Map<ProductCategory, List<Product>> map, Product product) {
        List<Product> products = map.computeIfAbsent(product.getCategory(), key -> new ArrayList<>());
        products.add(product);
    }
}
