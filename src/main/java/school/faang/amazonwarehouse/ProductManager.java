package school.faang.amazonwarehouse;

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
    private int currentId;

    public void addProduct(Category category, String name) {
        Product product = new Product(currentId++, name, category);
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
    }

    public void removeProduct(Category category, String name) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
            List<Product> categoryProducts = categoryMap.get(category);
            categoryProducts.remove(productToRemove);
            System.out.println("Product " + productToRemove + " removed");
        } else {
            System.out.println("Product " + productToRemove + " not found.");
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, Collections.emptyList());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            Category category = product.getCategory();
            productMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        }
        return productMap;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(" - " + product);
            }
        }
    }
}
