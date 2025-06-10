package school.faang.bjs2_79895;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private int uniqId = 1;
    private Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                throw new IllegalArgumentException("этот товар уже добавлен!");
            }
        }
        int id = uniqId++;
        Product product = new Product(id, name, category);
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove != null) {
            products.remove(productToRemove);
        } else {
            throw new IllegalArgumentException("такого товара не существует");
        }
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
        for (Product product : products) {
            result.computeIfAbsent(product.getCategory(), category -> new ArrayList<>()).add(product);
        }
        return result;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> grouped = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : grouped.entrySet()) {
            System.out.printf("CATEGORY %s%n", entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.printf("-PRODUCTS %s%n", product.getName());
            }
        }
    }
}


