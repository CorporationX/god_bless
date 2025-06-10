package school.faang.amazon_bjs2_79845;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private int nextId = 1;

    public int generateId() {
        return nextId++;
    }

    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Category category, String name) {
        if (category == null && name.isBlank()) {
            log.warn("Продукт или его имя не может быть null\n");
        } else {
            int id = generateId();
            Product product = new Product(id, name, category);
            log.info("Продукт успешно добавлен");
            products.add(product);
        }
    }

    public void removeProduct(school.faang.amazon_bjs2_79845.Category category, String name) {
        Product product = getProductByName(name);
        if (product != null) {
            Product productToRemove = new Product(product.getId(), name, category);
            products.remove(productToRemove);
            log.info("Продукт {} удален", name);
        } else {
            log.warn("Продукт {} не найден\n", name);
        }
    }

    public List<Product> findProductsByCategory(school.faang.amazon_bjs2_79845.Category category) {
        List<Product> productsInOneCategory = new ArrayList<>();

        log.info("Категория: %s\n", category);
        log.info("Продукты:\n");
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsInOneCategory.add(product);
                System.out.printf("- %s\n", product.getName());
            }
        }
        return productsInOneCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory(Category category) {
        Map<Category, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                groupedProducts.putIfAbsent(category, new ArrayList<>());
            }
        }
        return groupedProducts;
    }

    public void printAllProducts() {
        for (Product product : products) {
            System.out.printf("Элемент: %s\n", product);
        }
    }
}
