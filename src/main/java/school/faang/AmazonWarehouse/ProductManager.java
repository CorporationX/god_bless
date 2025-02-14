package school.faang.AmazonWarehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        if (!products.add(product)) {
            System.out.println("Product already exists: " + product);
        } else {
            categoryMap.computeIfAbsent(category, c -> new ArrayList<>()).add(product);
        }
    }

    public void removeProduct(Category category, String name) {
        validateName(name);
        List<Product> byCategory = categoryMap.get(category);
        if (byCategory != null) {
            boolean removed = byCategory.removeIf(product -> product.getName().equals(name));
            if (removed) {
                products.removeIf(product
                        -> product.getCategory() == category && product.getName().equals(name));
            }
        }

    }

    public List<Product> findProductsByCategory(Category category) {
        return Collections.unmodifiableList(categoryMap.getOrDefault(category, new ArrayList<>()));
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        products.forEach(p ->
                categoryMap.computeIfAbsent(p.getCategory(), v -> new ArrayList<>()).add(p));
    }

    public void printAllProducts() {
        categoryMap.forEach((category, productList) -> {
            System.out.println("Category: " + category);
            productList.forEach(product -> System.out.println(product.getName()));
            System.out.println();
        });
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
    }
}
