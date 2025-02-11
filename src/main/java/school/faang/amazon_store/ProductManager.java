package school.faang.amazon_store;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products;
    private final Map<Category, List<Product>> categoryMap;
    private static int currentId = 1;

    public ProductManager() {
        products = new HashSet<>();
        categoryMap = new HashMap<>();
    }

    public void addProduct(@NonNull Category category, @NonNull String name) {
        var product = new Product(currentId++, name, category);
        products.add(product);
        categoryMap.computeIfAbsent(category, v -> new ArrayList<>()).add(product);
    }

    public void removeProduct(@NonNull Category category, @NonNull String name) {
        categoryMap.values().forEach(list -> list.removeIf(
                product -> product.getName().equals(name) && product.getCategory().equals(category)));
        products.removeIf(
                product -> product.getName().equals(name) && product.getCategory().equals(category));
    }

    public List<Product> findProductsByCategory(@NonNull Category category) {
        return Collections.unmodifiableList(categoryMap.getOrDefault(category, List.of()));
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (var product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), v -> new ArrayList<>())
                    .add(product);
        }
    }

    public void printAllProducts() {
        categoryMap.forEach((k, v) -> {
            System.out.println("Category: " + k);
            List<Product> productList = v;
            System.out.println("Products:");
            productList.forEach(product -> System.out.println(product.getId() +
                    ". " + product.getName()));
        });
    }
}
