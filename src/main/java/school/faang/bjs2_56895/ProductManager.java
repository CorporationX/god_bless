package school.faang.bjs2_56895;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> categoryMap = new HashMap<>();
    private AtomicInteger idGenerator = new AtomicInteger();

    public void addProduct(Category category, String name) {
        Product newProduct = new Product(idGenerator.incrementAndGet(), name, category);
        if (products.add(newProduct)) {
            categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(newProduct);
        }
    }

    public void removeProduct(Category category, String name) {
        Product product = products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (product != null) {
            products.remove(product);

            List<Product> categoryProducts = categoryMap.get(category);
            if (categoryProducts != null) {
                categoryProducts.remove(product);
                if (categoryProducts.isEmpty()) {
                    categoryMap.remove(category);
                }
            }
        } else {
            System.out.printf("Product %s not found", name);
        }
    }

    public List<Product> findProductByCategory(Category category) {
        return categoryMap.getOrDefault(category, Collections.emptyList());
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
    }

    public void printAllProducts() {
        if (categoryMap.isEmpty()) {
            System.out.println("No products found");
            return;
        }

        categoryMap.forEach((category, products) -> {
            if (!products.isEmpty()) {
                System.out.println("Category: " + category);
                System.out.println("Products:");
                products.forEach(product -> System.out.println("- " + product.getName()));
                System.out.println(); // Пустая строка для разделения категорий
            }
        });
    }
}
