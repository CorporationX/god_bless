package school.faang.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class ProductsSystem {
    HashSet<Product> products = new HashSet<>();
    HashMap<String, List<Product>> categories = new HashMap<>();

    public void addItem(String name, String category) {
        String id = UUID.randomUUID().toString();
        Product product = new Product(id, name, category);
        products.add(product);
    }

    public void removeItem(String name, String category) {
        products.removeIf(item -> item.getName().equals(name) && item.getCategory().equals(category));
    }

    public HashSet<Product> findItemsByCategory(String category) {
        HashSet<Product> categoryProducts = new HashSet<>();
        for (Product item : products) {
            if (item.getCategory().equals(category)) {
                categoryProducts.add(item);
            }
        }
        return categoryProducts;
    }
}
