package school.faang.bjs245148;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductManager {

    private Map<String, List<Product>> categories = new HashMap<>();
    private AtomicInteger incrementId = new AtomicInteger(1);

    public void addItem(String category, String name) {
        if (category.isEmpty() || name.isEmpty()) {
            throw new IllegalArgumentException("Enter truly information");
        }
        Product product = new Product(incrementId.getAndIncrement(), name, category);
        categories.computeIfAbsent(category, key -> new ArrayList<>()).add(product);
    }

    public void removeItem(String category, String name) {
        findItemsByCategory(category).removeIf(product ->
                product.getCategory().equals(category) && product.getName().equals(name));
    }

    public List<Product> findItemsByCategory(String category) {
        if (!categories.containsKey(category)) {
            throw new IllegalArgumentException("Category not found !");
        }
        return categories.get(category);
    }

    public void printAllItems() {
        categories.forEach((category, products) -> {
            System.out.println("--------" + category + "----------");
            products.forEach(product -> {
                System.out.println(product.getId() + " - " + product.getCategory() + ":" + product.getName());
            });
        });
    }
}
