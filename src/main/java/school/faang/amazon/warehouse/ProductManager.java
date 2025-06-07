package school.faang.amazon.warehouse;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private Set<Product> products;
    private Map<Category, List<Product>> productsByCategory;

    public ProductManager() {
        this.products = new HashSet<>();
        this.productsByCategory = new HashMap<>();
    }

    public ProductManager(Set<Product> products) {
        this.products = products;
        this.productsByCategory = new HashMap<>();
    }

    public Product addProduct(Category category, String name) {
        Product product = findProductByCategory(category, name);
        if (product != null) {
            System.out.printf("product in category: %s with name: %s is already exists\n", category, name);
            return product;
        }

        product = new Product(name, category);
        products.add(product);
        productsByCategory.get(category).add(product);
        return product;
    }

    public Product removeProduct(Category category, String name) {
        Product product = findProductByCategory(category, name);
        if (product == null) {
            return null;
        }

        products.remove(product);
        productsByCategory.get(category).remove(product);
        return product;
    }

    public List<Product> findProductsByCategory(Category category) {
        return productsByCategory.computeIfAbsent(category, c -> new ArrayList<>());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return productsByCategory;
    }

    public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Склад пустой!");
            return;
        }

        for (Map.Entry<Category, List<Product>> entry : productsByCategory.entrySet()) {
            if (entry.getValue().isEmpty()) {
                continue;
            }

            System.out.printf("Категория: %s\n", entry.getKey().toString());
            System.out.println("Продукты:");
            entry.getValue().forEach(product -> System.out.printf("- %s\n", product.getName()));
            System.out.println();
        }
    }

    private Product findProductByCategory(Category category, String name) {
        List<Product> productList = productsByCategory.computeIfAbsent(category, category1 -> new ArrayList<>());
        for (Product product : productList) {
            if (name.equals(product.getName())) {
                return product;
            }
        }

        return null;
    }
}
