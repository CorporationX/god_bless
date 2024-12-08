package school.faang.bjs245160;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ProductStorage {
    private final Map<String, List<Product>> productsByCategory = new HashMap<>();

    public void addItem(String category, String name) {
        productsByCategory.computeIfAbsent(category, k -> new ArrayList<>()).add(new Product(name, category));
    }

    public void removeItem(String category, String name) throws IllegalArgumentException {
        checkCategory(category);

        List<Product> products = productsByCategory.get(category);
        List<Product> productsToRemove = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                productsToRemove.add(product);
            }
        }

        if (productsToRemove.isEmpty()) {
            throw new IllegalArgumentException("Product: \"" + name + "\" does not exist");
        }

        products.removeAll(productsToRemove);
    }

    public List<Product> findItemsByCategory(String category) {
        List<Product> products = productsByCategory.get(category);
        if (products == null) {
            throw new IllegalArgumentException("Category: \"" + category + "\" does not exist");
        }
        return products;
    }

    public void printAllItems() {
        System.out.println(productsByCategory);
    }

    private void checkCategory(String category) {
        if (!productsByCategory.containsKey(category)) {
            throw new IllegalArgumentException("Category: \"" + category + "\" does not exist");
        }
    }
}
