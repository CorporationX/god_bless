package school.faang.dismantling_warehouse_amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        products.add(new Product(name, category));
    }

    public void removeProduct(Category category, String name) {
        Product product = null;
        for (Product tmp : products) {
            if (tmp.getName().equals(name) && tmp.getCategory().equals(category)) {
                product = tmp;
            }
        }
        products.remove(product);
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                result.add(product);
            }
        }
        return result;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> result = new HashMap<>();
        for (Category category : Category.values()) {
            result.put(category, findProductsByCategory(category));
        }
        return result;
    }

    public void printAllProducts() {
        for (Category category : Category.values()) {
            System.out.println("Категория: " + category + "\n" + "Продукты:");
            for (Product product : findProductsByCategory(category)) {
                System.out.printf("- %s\n", product.getName());
            }
            System.out.println();

        }
    }

}
