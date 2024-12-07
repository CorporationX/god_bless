package school.faang.task_43518;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public interface ProductManagement {
    static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        return null;
    }

    static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        return;
    }

    void addItem(String category, String name);

    void removeItem(String category, String name);

    void findItemsByCategory(String category);

    void printAllItems();


}
