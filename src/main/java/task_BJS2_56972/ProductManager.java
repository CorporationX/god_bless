package task_BJS2_56972;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> categoryMap = new HashMap<>();
    private static int currentId = 0;

    public void addProduct(@NonNull Category category, @NonNull String name) {
        Product product = new Product(currentId++, name, category);
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            categoryMap.get(product.getCategory()).add(product);
        }

        return categoryMap;
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public void removeProduct(Category category, @NonNull String name) {
        products.removeIf(product -> product.getName().equals(name) && product.getCategory().equals(category));

        List<Product> listOfCategory = categoryMap.get(category);
        listOfCategory.removeIf(product -> product.getName().equals(name));
    }

    public void printAllProducts() {
        for (var entry : categoryMap.entrySet()) {
            System.out.printf("\nКатегория: %s\nПродукты:\n", entry.getKey());
            for (var product : entry.getValue()) {
                System.out.printf("- %s\n", product.getName());
            }
        }
    }
}
