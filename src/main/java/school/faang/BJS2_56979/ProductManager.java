package school.faang.BJS2_56979;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private int currentId = 1;

    public void addProduct(Category category, String name) {
        Product product = new Product(currentId, name, category);
        currentId++;
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
    }

    public void removeProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                categoryMap.get(category).remove(product);
                if (categoryMap.get(category).isEmpty()) {
                    categoryMap.remove(category);
                }
                products.remove(product);
                return;
            }
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            categoryMap.get(product.getCategory()).add(product);
        }
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            System.out.println("Продукты:");
            for (Product product : entry.getValue()) {
                System.out.println(" - " + product.getName());
            }
        }
    }
}
