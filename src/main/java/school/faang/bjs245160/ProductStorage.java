package school.faang.bjs245160;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ProductStorage {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addItem(String category, String name) {
        products.computeIfAbsent(category, k -> new ArrayList<>()).add(new Product(name, category));
    }

    public void removeItem(String category, String name) throws IllegalArgumentException {
        checkCategoryAndProduct(category, name);
        products.get(category).remove(new Product(name, category));
    }

    public List<Product> findItemsByCategory(String category) {
        checkCategory(category);
        return products.get(category);
    }

    public void printAllItems() {
        System.out.println(products);
    }

    private void checkCategory(String category) {
        if (!products.containsKey(category)) {
            throw new IllegalArgumentException("Category: \"" + category + "\" does not exist");
        }
    }

    private void checkCategoryAndProduct(String category, String name) {
        checkCategory(category);
        if (!products.get(category).contains(new Product(name, category))) {
            throw new IllegalArgumentException("Product: \"" + name + "\" does not exist");
        }
    }
}
