package school.faang.bjs2_69862;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        var product = new Product(category, name);
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        boolean removed = products.removeIf(product ->
                Objects.equals(product.getCategory(), category) &&
                        Objects.equals(product.getName(), name)
        );

        if (!removed) {
            log.warn("Продукт не найден: {}, {}", name, category);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return products.stream()
                .filter(p -> p.getCategory() == category)
                .collect(Collectors.toList());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        var groupedProducts = groupProductsByCategory();
        for (var category : Category.values()) {
            var products = groupedProducts.getOrDefault(category, new ArrayList<>());
            log.info("Категория: {}", category);

            if (products.isEmpty()) {
                log.info("Нет продуктов.");
                continue;
            }

            log.info("Продукты:");
            products.forEach(product -> log.info("- {}", product.getName()));

            log.info("");
        }
    }
}