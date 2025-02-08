package school.faang.BJS2_56979;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private static final Set<Product> PRODUCTS = new HashSet<>();
    private static final Map<Category, List<Product>> CATEGORY_MAP = new HashMap<>();
    private int currentId = 1;

    public void addProduct(Category category, String name) {
        Product product = new Product(currentId, name, category);
        currentId++;
        PRODUCTS.add(product);
        CATEGORY_MAP.putIfAbsent(category, new ArrayList<>());
        CATEGORY_MAP.get(category).add(product);
    }

    public void removeProduct(Category category, String name) {
        for (Product product : PRODUCTS) {
            if (product.getName().equals(name)) {
                CATEGORY_MAP.get(category).remove(product);
                PRODUCTS.remove(product);
                return;
            }
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        CATEGORY_MAP.putIfAbsent(category, new ArrayList<>());
        return CATEGORY_MAP.get(category);
    }

    public void groupProductsByCategory() {
        for (Product product : PRODUCTS) {
            CATEGORY_MAP.putIfAbsent(product.getCategory(), new ArrayList<>());
            CATEGORY_MAP.get(product.getCategory()).add(product);
        }
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : CATEGORY_MAP.entrySet()) {
            Category category = entry.getKey();
            List<Product> productsByCategory = entry.getValue();
            System.out.println("Категория: " + category);
            System.out.println("Продукты:");
            for (Product product : productsByCategory) {
                System.out.println(" - " + product.getName());
            }
        }
    }
}
