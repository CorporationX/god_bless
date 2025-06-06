package school.faang.amazon;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class ProductManager {

    private final Set<Product> products = new HashSet<>();
    private Integer lastId = 0;

    public void addProduct(@NonNull Category category, @NonNull String name) {
        products.add(new Product(lastId++, name, category));
    }

    public void removeProduct(@NonNull Category category, @NonNull String name) {
        var isRemoved = products.removeIf(product -> product.getName().equals(name)
                && product.getCategory().equals(category));
        if (isRemoved) {
            System.out.printf("Product with name = '%s' and category = '%s' removed\n", name, category);
        }
    }

    public List<Product> findProductsByCategory(@NonNull Category category) {
        return products.stream()
                .filter(p -> p.getCategory().equals(category))
                .toList();
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        var productsByCategory = groupProductsByCategory();
        for (var entry : productsByCategory.entrySet()) {
            System.out.printf("Категория: %s\n", entry.getKey());
            System.out.println("Продукты:");
            for (var product : entry.getValue()) {
                System.out.printf("- %s\n", product.getName());
            }
            System.out.println();
        }
    }
}
