package school.faang.amazonstorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductManager {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();


    protected boolean addProduct(Category category, String name) {
        Product productToAdd = new Product(ID_GENERATOR.incrementAndGet(), name, category);

        boolean isAdded = products.add(productToAdd);

        if (isAdded) {
            categoryMap.computeIfAbsent(category, product -> new ArrayList<>()).add(productToAdd);
            return true;
        }

        return false;
    }

    protected boolean removeProduct(Category category, String name) {
        List<Product> productsList = categoryMap.get(category);

        if (!products.isEmpty()) {
            Product product = new Product(name, category);
            if (productsList.contains(product)) {
                productsList.remove(product);
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    protected List<Product> findProductsByCategory(Category category) {
        return new ArrayList<>(categoryMap.getOrDefault(category, Collections.emptyList()));
    }

    protected void groupProductsByCategory() {
        categoryMap.clear();

        for (Product product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), productToAdd -> new ArrayList<>()).add(product);
        }
    }

    protected void printAllProducts() {
        for (var entry : categoryMap.entrySet()) {
            if (entry.getValue() != null) {
                System.out.println("Категория: " + entry.getKey());
                System.out.println("Продукты: ");
                entry.getValue().forEach(System.out::println);
            }
        }
    }
}
