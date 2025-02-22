package marketplace;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private int id;

    public void addProduct(Category category, String name) {
        if (category == null || name == null || name.isBlank()) {
            System.out.println("Invalid product data.");
            return;
        }

        int currentId = id++;
        Product product = new Product(currentId, name, category);

        if (!products.add(product)) {
            System.out.println("Product with this name already exists.");
            return;
        }

        categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        System.out.println("Added " + product);
    }

    public void removeProduct(Category category, String name) {
        if (category == null || name == null || name.isBlank()) {
            System.out.println("Invalid product data.");
            return;
        }

        products.removeIf(product -> product.getName().equals(name) && product.getCategory() == category);

        List<Product> productList = categoryMap.get(category);
        if (productList != null) {
            productList.removeIf(product -> product.getName().equals(name));
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        if (category == null) {
            System.out.println("Category cannot be null.");
            return new ArrayList<>();
        }
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            productMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return productMap;
    }

    public void printAllProducts() {
        categoryMap.forEach((category, products) -> {
            System.out.println("Category: " + category + "\nProducts:");
            products.forEach(product -> System.out.println("- " + product));
        });
    }

}
