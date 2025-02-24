package school.faang.task_45172;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class ProductRepository {
    private final Map<String, Set<Product>> productsByCategory = new HashMap<>();

    public void addItem(String category, String name) {
        Product product = new Product(name, category);
        productsByCategory.computeIfAbsent(category, k -> new HashSet<>()).add(product);
    }

    public void removeItem(String category, String name) {
        if (productsByCategory.containsKey(category)) {
            Set<Product> products = productsByCategory.get(category);
            boolean success = products.removeIf(product -> Objects.equals(product.getName(), name));
            if (!success) {
                System.out.println("Unable to delete. Product not found");
            }
        } else {
            System.out.println("category not found");
        }
    }

    public Set<Product> findItemsByCategory(String category) {
        return Optional.ofNullable(productsByCategory.get(category)).orElseThrow(
                () -> new IllegalArgumentException("Category not found"));
    }

    public void printAllItems() {
        Collection<Set<Product>> values = productsByCategory.values();
        for (Set<Product> set : values) {
            for (Product p : set) {
                System.out.println(p);
            }
        }
    }
}