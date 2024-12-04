package school.faang.task_45098;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class Warehouse {
    private final Map<String, List<Product>> productsByCategory;
    private final Set<Product> products;

    public Warehouse(Map<String, List<Product>> productsByCategory) {
        this.productsByCategory = productsByCategory;
        this.products = productsByCategory.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public void addItem(String category, String name) {
        if (!productsByCategory.containsKey(category)) {
            productsByCategory.put(category, List.of(new Product(generateId(), name, category)));
        }
        Product newProduct = new Product(generateId(), name, category);
        productsByCategory.computeIfAbsent(category, (s) -> new ArrayList<>()).add(newProduct);
        products.add(newProduct);
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

    public void removeItem(String category, String name) {
        checkCategory(category);
        List<Product> currentProductsByCategory = productsByCategory.get(category);
        if (currentProductsByCategory.isEmpty()) {
            throw new IllegalArgumentException("Products don't exist in current category: " + category);
        }
        deleteFromProducts(currentProductsByCategory, name);
        currentProductsByCategory = currentProductsByCategory.stream()
                .filter(p -> !p.getName().equals(name))
                .toList();
        productsByCategory.replace(category, currentProductsByCategory);
    }

    private void checkCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Current category doesn't exist");
        }
    }

    private void deleteFromProducts(List<Product> currentProductsByCategory, String name) {
        currentProductsByCategory.stream()
                .filter(f -> f.getName().equals(name))
                .forEach(products::remove);
    }

    public List<Product> findItemsByCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category doesn't exist");
        }
        List<Product> itemsByCategory = productsByCategory.get(category);
        if (itemsByCategory == null || itemsByCategory.isEmpty()) {
            throw new IllegalArgumentException("Not found items");
        }
        return productsByCategory.get(category);
    }

    public void printAllItems() {
        System.out.println("Print all items: ");
        for (var entry : this.productsByCategory.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
