package school.faang.sprint1.task_BJS2_56911;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// for test
@Getter
public class ProductManager {
    private final Map<Category, List<Product>> categoryMap = new EnumMap<>(Category.class);
    private final Map<String, Product> productsOnKey = new HashMap<>();
    private String productKey;
    private Product product;


    public void addProduct(Category category, @NonNull String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        productKey = createProductKey(category, name);

        if (!productsOnKey.containsKey(productKey)) {
            product = new Product(category, name);
            categoryMap.computeIfAbsent(category, k -> new ArrayList<>());
            categoryMap.get(category).add(product);
            productsOnKey.put(productKey, product);
        }
    }

    public void removeProduct(Category category, String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        productKey = createProductKey(category, name);

        if (productsOnKey.containsKey(productKey)) {
            product = productsOnKey.get(productKey);
            categoryMap.get(category).remove(product);
            productsOnKey.remove(productKey);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public void groupProductsByCategory() {
        categoryMap.clear();

        productsOnKey.values().forEach(product -> {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>());
            categoryMap.get(product.getCategory()).add(product);
        });
    }

    public void printAllProducts() {
        categoryMap.forEach((category, products) -> {
            System.out.printf("Категория: %s\nПродукты:\n", category);
            products.forEach(product -> System.out.println("- " + product.getName()));
            System.out.println();
        });
    }

    private String createProductKey(Category category, String name) {
        return String.format("%s_%s", category, name);
    }
}
