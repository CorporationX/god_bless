package school.faang.task_57021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet();
    private final Map<Category, List<Product>> categoryMap = new HashMap();

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);
        categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    }

    public void removeProduct(Category category, String name) {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            if (entry.getKey().equals(category)) {
                entry.getValue().removeIf(product -> product.getName().equals(name));
            }
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public static Map<Category, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<Category, List<Product>> productMap = new HashMap<>();

        for (Product product : products) {
            if (!productMap.containsKey(product.getCategory())) {
                productMap.put(product.getCategory(), new ArrayList<>());
            }
            productMap.get(product.getCategory()).add(product);
        }

        return productMap;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("Категория: " + entry.getKey() + System.lineSeparator() + "Продукты: ");
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
        }
    }
}


