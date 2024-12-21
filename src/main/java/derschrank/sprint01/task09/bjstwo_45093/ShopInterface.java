package derschrank.sprint01.task09.bjstwo_45093;

import java.util.Map;
import java.util.Set;

public interface ShopInterface {
    void addItem(String category, String product);

    void removeItem(String category, String name);

    Set<Product> findItemsByCategory(String category);

    void printAllItems();

    Map<String, Set<Product>>  groupProductsByCategory(Set<Product> products);

    void printProductsByCategory(Map<String, Set<Product>> groupedProducts);
}
