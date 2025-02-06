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
    private Map<Category, List> categoryMap = new HashMap<>();
    private static int id = 0;

    public void addProduct(Category category, @NonNull String name) {
        Product product = new Product(id, name, category);

        products.add(product);

        categoryMap.putIfAbsent(category, new ArrayList());
        categoryMap.get(category).add(product);

        id++;
    }
}
