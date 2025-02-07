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
        currentId = product.getId() + 1;
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<Product>());
        categoryMap.get(category).add(product);
    }

    public void removeProduct(Category category, @NonNull String name) {
        products.removeIf(product -> product.getName().equals(name) && product.getCategory().equals(category));

        List<Product> listOfCategory = categoryMap.get(category);
        listOfCategory.removeIf(product -> product.getName().equals(name));
    }
}
