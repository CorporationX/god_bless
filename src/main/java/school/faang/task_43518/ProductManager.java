package school.faang.task_43518;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Getter
@Slf4j
public class ProductManager implements ProductManageable {
    private final Map<String, List<Product>> productsMap = new HashMap<>();

    public ProductManager(Set<Product> products) {
        for (Product product : products) {
            productsMap.computeIfAbsent(product.getCategory(),
                            k -> new ArrayList<>())
                    .add(product);
        }
    }

    @Override
    public void addItem(String category, String name) {
        Product product = new Product(name, category);
        productsMap.computeIfAbsent(product.getCategory(),
                        k -> new ArrayList<>())
                .add(product);
    }

    @Override
    public void removeItem(String category, String name) {
        // Product product = new Product(id, name, category);
        try {
            List<Product> products = Optional
                    .ofNullable(productsMap.get(category))
                    .orElseThrow(() ->
                            new NoSuchElementException("Category not found: " + category)
                    );
            if (!products.removeIf(product -> product.getName()
                    .equals(name))) {
                throw new NoSuchElementException("Product not found: " + name);
            }
        } catch (NoSuchElementException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public void findItemsByCategory(String category) {
        try {
            Optional.ofNullable(productsMap.get(category))
                    .ifPresentOrElse(products -> {
                        System.out.println(category + ": ");
                        productsMap.get(category)
                                .forEach(product ->
                                        System.out.println("   " + product));
                    }, () -> {
                        throw new NoSuchElementException("Category not found: "
                                + category);
                    });
        } catch (NoSuchElementException ex) {
            log.error(ex.getMessage());
        }
    }

    @Override
    public void printAllItems() {
        productsMap.values().forEach(products ->
                products.forEach(System.out::println));
    }

    public Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(),
                            k -> new ArrayList<>())
                    .add(product);
        }
        return groupedProducts;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.forEach((category, products) -> {
            System.out.println(category + ": ");
            products.forEach(product -> System.out.println("   " + product));
        });
    }
}

