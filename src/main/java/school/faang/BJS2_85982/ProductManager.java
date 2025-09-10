package school.faang.BJS2_85982;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private int id = 1;

    public void addProduct(Category category, String name) {
        Product newProduct = new Product(id++, name, category);
        products.add(newProduct);
    }

    public void removeProduct(Category category, String name) {
        Product removedProduct = new Product(id, name, category);
        products.remove(removedProduct);
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                result.add(product);
            }
        }
        return result;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> result = new HashMap<>();
        for (Product product : products) {
            result.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return result;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> productMap = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> e : productMap.entrySet()) {
            System.out.println("Категория: " + e.getKey());
            System.out.println("Продукты:");
            for (Product product : e.getValue()) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        }
    }
}
