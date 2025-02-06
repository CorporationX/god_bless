package school.faang.sprint1.task_BJS2_56911;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManager {
    private final Map<Category, List<Product>> categoryMap = new EnumMap<>(Category.class);
    private final Map<String, Product> productOnKey = new HashMap<>();
    private String productKey;
    private Product product;

    public void addProduct(Category category, @NonNull String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        productKey = getProductKey(category, name);

        if (!productOnKey.containsKey(productKey)) {
            product = new Product(category, name);
            categoryMap.computeIfAbsent(category, k -> new ArrayList<>());
            categoryMap.get(category).add(product);
            productOnKey.put(productKey, product);
        }

    }

    public void removeProduct(Category category, String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        productKey = getProductKey(category, name);

        if (productOnKey.containsKey(productKey)) {
            product = productOnKey.get(productKey);
            categoryMap.get(category).remove(product);
            productOnKey.remove(productKey);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public void groupProductsByCategory() {
        categoryMap.clear();

        productOnKey.values().forEach(product -> {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>());
            categoryMap.get(product.getCategory()).add(product);
        });
    }

    public void printAllProducts() {
        productOnKey.values().forEach(System.out::println);
    }

    private String getProductKey(Category category, String name) {
        return String.format("%s-%s", category, name);
    }
}
