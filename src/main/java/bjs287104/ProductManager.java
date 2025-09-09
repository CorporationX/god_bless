package bjs287104;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> categoryAndProducts = new HashMap<>();
    private static int id = 1;

    public void addProduct(Category category, String name) {
        if (category == null || name == null) {
            throw new IllegalArgumentException("category and name must not be null");
        }
        Product product = new Product(id, name, category);
        id++;
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        if (category == null || name == null) {
            throw new IllegalArgumentException("category and name must not be null");
        }
        products.removeIf(product -> product.getCategory().equals(category)
                && product.getName().equals(name));
    }

    public List<Product> findProductsByCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("category must not be null");
        }
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        for (Product product : products) {
            if (!categoryAndProducts.containsKey(product.getCategory())) {
                categoryAndProducts.put(product.getCategory(), new ArrayList<>());
            }
            categoryAndProducts.get(product.getCategory()).add(product);
        }
        return categoryAndProducts;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> productsPerCategory : categoryAndProducts.entrySet()) {
            System.out.println("Category: " + productsPerCategory.getKey());
            for (Product product : productsPerCategory.getValue()) {
                System.out.println(product);
            }
        }
    }
}
