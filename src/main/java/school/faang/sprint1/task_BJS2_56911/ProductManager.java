package school.faang.sprint1.task_BJS2_56911;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// for test
@Getter
public class ProductManager {
    private final Map<Category, List<Product>> categoryMap = new EnumMap<>(Category.class);
    private final Set<Product> products = new HashSet<>();
    private Product product;


    public void addProduct(@NonNull Category category, @NonNull String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        product = new Product(category, name);
        categoryMap.computeIfAbsent(category, k -> new ArrayList<>());
        categoryMap.get(category).add(product);
        products.add(product);
    }

    public void removeProduct(@NonNull Category category, @NonNull String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        product = new Product(category, name);

        if (categoryMap.containsKey(category)) {
            categoryMap.get(category).removeIf(productMap -> isEquals(productMap, product));
            products.removeIf(productSet -> isEquals(productSet, product));
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public void groupProductsByCategory() {
        categoryMap.clear();

        products.forEach(product -> {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>());
            categoryMap.get(product.getCategory()).add(product);
        });
    }

    public void printAllProducts() {
        categoryMap.forEach((category, products) -> {
            System.out.printf("Категория: %s\nПродукты:\n", category);
            products.forEach(product -> System.out.println("- " + product.getName()));
            System.out.println();
        });
    }

    private boolean isEquals(Product product1, Product product2) {
        if (!product1.getName().equals(product2.getName())) {
            return false;
        }
        return product1.getCategory() == product2.getCategory();
    }
}
