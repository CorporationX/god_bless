package school.faang.wearhouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {

    private Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        if (products.contains(product)) {
            return;
        }
        products.add(product);
        categoryMap.computeIfAbsent(category, productList -> new ArrayList<>());
        if (!categoryMap.get(category).contains(product)) {
            categoryMap.get(category).add(product);
        }
    }

    public void removeProduct(Category category, String name) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                productToRemove = product;
            }
        }
        if (productToRemove == null) {
            return;
        }
        products.remove(productToRemove);
        if (categoryMap.containsKey(category)) {
            List<Product> productsByCategory = categoryMap.get(category);
            productsByCategory.remove(productToRemove);
            if (productsByCategory.isEmpty()) {
                categoryMap.remove(category);
            }
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsByCategory = categoryMap.get(category);
        return (productsByCategory != null) ? productsByCategory : Collections.emptyList();
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.computeIfAbsent(product.getCategory(),
                    k -> new ArrayList<>()).add(product);
        }
    }

    public void printAllCategories() {
        for (Map.Entry<Category, List<Product>> products : categoryMap.entrySet()) {
            System.out.println("=".repeat(30));
            System.out.println("В категории: " + products.getKey() + " есть в наличии:");
            for (Product product : products.getValue()) {
                System.out.println(" - " + product.getName());
            }
        }
        System.out.println("=".repeat(30));
    }
}
