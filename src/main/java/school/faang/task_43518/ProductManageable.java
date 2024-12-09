package school.faang.task_43518;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public interface ProductManageable {
    void addItem(String category, String name);

    void removeItem(String category, String name) throws NoSuchElementException;

    void findItemsByCategory(String category) throws NoSuchElementException;

    void printAllItems();

    Map<String, List<Product>> groupProductsByCategory(Set<Product> products);

    void printProductsByCategory(Map<String, List<Product>> groupedProducts);
}
