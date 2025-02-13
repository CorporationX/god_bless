package school.faang.task_57215;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(@NonNull Category category, @NonNull String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println("Товар с таким именем уже существует в категории " + category);
                return;
            }
        }
        Product product = new Product(name, category);
        products.add(product);
        System.out.println("Добавлен товар: " + product);
        groupProductsByCategory();
    }

    public void removeProduct(Category category, String name) {
        Product toRemove = null;
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                toRemove = product;
                break;
            }
        }
        if (toRemove != null) {
            products.remove(toRemove);
            System.out.println("Удален товар: " + toRemove);
            groupProductsByCategory();
        } else {
            System.out.println("Товар не найден.");
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap
                    .computeIfAbsent(product.getCategory(), k -> new ArrayList<>())
                    .add(product);
        }
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("  - " + product.getName());
            }
        }
    }
}
