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


    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
    }

    public void removeProduct(Category category, String name) {
        Product product = new Product(name, category);
        categoryMap.get(category).remove(product);
        products.remove(product);
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, Collections.emptyList());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            Category category = product.getCategory();
            productMap.putIfAbsent(category, new ArrayList<>());
            productMap.get(category).add(product);
        }
        return productMap;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(" - " + product.getName());
            }
        }
    }
}
