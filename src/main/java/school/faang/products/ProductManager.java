package school.faang.products;

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

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        if (products.add(product)) {
            categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        }
    }

    public void removeProduct(Category category, String name) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory() == category) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
            categoryMap.getOrDefault(category, new ArrayList<>()).remove(productToRemove);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, Collections.emptyList());
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
    }

    public void printAllProducts() {
        for (Category category : categoryMap.keySet()) {
            System.out.println("Category: " + category);
            System.out.println("Products:");
            for (Product product : categoryMap.get(category)) {
                System.out.println("– " + product.getName());
            }
            System.out.println();
        }
    }
}
