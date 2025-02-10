package school.faang.BJS2_56917;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger(1);

    public void addProduct(Category category, String name) {
        if (category == null) {
            System.out.println("⚠️ Category cannot be null.");
            return;
        }

        Product newProduct = new Product(counter.getAndIncrement(), name, category);
        products.add(newProduct);
        categoryMap.computeIfAbsent(category, (k -> new ArrayList<>())).add(newProduct);
    }

    public void removeProduct(Category category, String name) {
        if (category == null) {
            System.out.println("⚠️ Category cannot be null.");
            return;
        }

        Product newProduct = new Product(counter.getAndIncrement(), name, category);

        if (!products.contains(newProduct)) {
            System.out.printf("⚠️ Продукт \"%s\" в категории \"%s\" не найден!%n", name, category);
            return;
        }

        products.remove(newProduct);
        categoryMap.get(category).remove(newProduct);
    }

    public List<Product> findProductsByCategory(Category category) {
        if (category == null) {
            System.out.println("⚠️ Category cannot be null.");
            return new ArrayList<>();
        }

        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public void groupProductsByCategory() {
        categoryMap.clear();

        products.forEach(product -> {
            categoryMap.computeIfAbsent(product.getCategory(), (k) -> new ArrayList<>()).add(product);
        });
    }

    public void printAllProducts() {
        categoryMap.forEach((key, value) -> {
            System.out.printf("Категория: %s%n", key);
            value.forEach(product -> {
                System.out.printf("Продукты:");
                System.out.printf("- %s%n", product.getName());
            });
            System.out.printf("-------------------%n");
        });
    }

}
