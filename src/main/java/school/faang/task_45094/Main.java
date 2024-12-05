package school.faang.task_45094;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void addItem(Map<String, List<Product>> productMap, String category, Integer id, String name) {
        try {
            var newProduct = new Product(id, name, category);
            if (productMap != null) {
                productMap.computeIfAbsent(category, k -> new ArrayList<>()).add(newProduct);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
