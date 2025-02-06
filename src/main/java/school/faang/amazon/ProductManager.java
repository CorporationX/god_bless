package school.faang.amazon;

import java.util.ArrayList;
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
        if (!products.add(product)) {
            System.out.println("The product already exists");
            return;
        }
        if (categoryMap.containsKey(category)) {
            categoryMap.get(category).add(product);
        } else {
            categoryMap.put(category, new ArrayList<>(List.of(product)));
        }
    }

    public void removeProduct(Category category, String name) {
        Product product = new Product(name, category);
        if (!products.remove(product)) {
            System.out.println("This product does not exist");
            return;
        }
        if (categoryMap.containsKey(category)) {
            categoryMap.get(category).remove(product);
        }
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.printf("Category: %s%nProduct:%n", entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("- " + product);
            }
            System.out.println();
        }
    }
}
