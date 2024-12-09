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
            List<Product> productList = getOrCreateProductsByCategory(
                    productsMap, product.getCategory());
            productList.add(product);
        }
    }

    @Override
    public void addItem(String category, String name) {
        Product product = new Product(name, category);
        List<Product> productsList = getOrCreateProductsByCategory(
                productsMap, category);
        productsList.add(product);
    }

    @Override
    public void removeItem(String category, String name) throws NoSuchElementException {
        List<Product> products = getProductsByCategory(category);
        Product product = products.stream()
                .filter((p -> p.getName().equals(name)))
                .findFirst()
                .orElseThrow(() -> {
                    String message = "Product not found: " + name;
                    log.error(message);
                    return new NoSuchElementException(message);
                });
        products.remove(product);
    }

    @Override
    public void findItemsByCategory(String category) throws NoSuchElementException {
        List<Product> products = getProductsByCategory(category);
        printAllItemsByCategory(category, products);
    }

    @Override
    public void printAllItems() {
        productsMap.forEach(this::printAllItemsByCategory);
    }

    public Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            List<Product> productList = getOrCreateProductsByCategory(
                    groupedProducts, product.getCategory());
            productList.add(product);
        }
        return groupedProducts;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.forEach(this::printAllItemsByCategory);
    }

    private void printAllItemsByCategory(String category, List<Product> products) {
        System.out.println(category + ": ");
        products.forEach(product -> System.out.println("\t" + product));
    }

    private List<Product> getProductsByCategory(String category) throws NoSuchElementException {
        return Optional.ofNullable(productsMap.get(category))
                .orElseThrow(() -> {
                    String message = "Category not found: " + category;
                    log.error(message);
                    return new NoSuchElementException(message);
                });
    }

    private List<Product> getOrCreateProductsByCategory(Map<String, List<Product>> productsMap, String category) {
        return productsMap.computeIfAbsent(category, k -> new ArrayList<>());
    }
}

