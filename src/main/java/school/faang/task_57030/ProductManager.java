package school.faang.task_57030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductManager {

    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private int productIdCounter = 1;

    public void addProduct(Category category, String name) {
        if (category == null || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("category or name is null");
        }
        Product product = new Product(productIdCounter++, name, category);
        if (products.contains(product)) {
            log.info("Данный продукт уже существует: {}", product.getName());
            return;
        }
        products.add(product);
        categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        log.info("Добавлен новый продукт: {}, в категорию {}", product.getName(), category);

    }

    public void removeProduct(Category category, String name) {
        if (category == null || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("category or name is null");
        }
        List<Product> productsInCategory = categoryMap.get(category);
        if (productsInCategory != null) {
            productsInCategory.removeIf(product -> product.getName().equals(name));
            log.info("Удален продукт: {}, из категории {}", name, category.name());
        }
        products.removeIf(product -> product.getCategory() == category && product.getName().equals(name));
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> products = categoryMap.get(category);
        if (products != null) {
            log.info("Категория {} найдена.", category.name());
            return products;
        }
        return List.of();
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            Category category = entry.getKey();
            List<Product> products = entry.getValue();

            System.out.printf("\nКатегория: %s\nПродукты:\n", category);
            for (Product product : products) {
                System.out.printf("- %s\n", product.getName());
            }
        }
    }
}
