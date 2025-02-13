package school.faang.bjs2_57225;

import lombok.NonNull;

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

    public void addProduct(@NonNull Category category, @NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым или состоять из пробелов");
        }
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                throw new IllegalArgumentException("Товар с таким именем уже существует " +
                        "в категории " + category);
            }
        }
        Product product = new Product(name, category);
        products.add(product);
        categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    }

    public void removeProduct(@NonNull Category category, @NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым или состоять из пробелов");
        }
        Product productToRemove = findProduct(category, name);
        if (productToRemove != null) {
            products.remove(productToRemove);

            List<Product> categoryProducts = categoryMap.get(category);
            if (categoryProducts != null) {
                categoryProducts.remove(productToRemove);
            }
        }
    }

    private Product findProduct(@NonNull Category category, @NonNull String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                return product;
            }
        }
        throw new IllegalArgumentException("Продукт не найден");
    }

    public List<Product> findProductsByCategory(@NonNull Category category) {
        if (categoryMap.containsKey(category)) {
            return Collections.unmodifiableList(categoryMap.get(category));
        } else {
            return Collections.emptyList();
        }
    }

    public void groupProductsByCategory() {
        categoryMap.clear();

        for (Product product : products) {
            Category category = product.getCategory();
            categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        }
    }

    public void printAllProducts() {
        categoryMap.forEach((category, products) -> {
            System.out.printf("Категория: %s\nПродукты:\n", category);
            products.forEach(product -> System.out.println("- " + product.getName()));
            System.out.println();
        });
    }

}
