package bjs287104;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private Set<Product> products;
    Map<Category, List<Product>> categoryAndProducts;
    static int id = 1;

    public ProductManager() {
        this.products = new HashSet<>();
    }

    public void addProduct(Category category, String name) {
        Product product = new Product(id, name, category);
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(product -> product.getCategory().equals(category)
                && product.getName().equals(name));
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        categoryAndProducts = new HashMap<>();
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
