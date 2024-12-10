package school.faang.task_43518;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public interface ProductManageable {
    void addItem(Category category, String name);

    void removeItem(Category category, String name) throws NoSuchElementException;

    void findItemsByCategory(Category category) throws NoSuchElementException;

    void printAllItems();

    Map<Category, List<Product>> groupProductsByCategory(Set<Product> products);

    void printProductsByCategory(Map<Category, List<Product>> groupedProducts);
}
