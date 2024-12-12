package derschrank.task09.bjstwo_45093;

import java.util.Map;
import java.util.Set;

public interface ShopInterface {
    void addItem(String category, Product product);

    void removeItem(String category, String name);

    Set<Product> findItemsByCategory(String category);

    void printAllItems();

    Map<Category, Set<Product>> groupProductsByCategory(Set<Product> products);

    void printProductsByCategory(Map<Category, Set<Product>> groupedProducts);
}
