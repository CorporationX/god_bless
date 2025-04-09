package school.faang.bjs2_68676;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ProductManager {
    Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        if (category == null || name == null || name.trim().isEmpty()) {
            log.error("Category or name is invalid.");
            throw new IllegalArgumentException("Category or name cannot be null or empty.");
        }
        Product product = new Product(name, category);
        products.add(product);
        log.info("Product added: {} (Category: {})", name, category);
    }

    public void removeProduct(Category category, String name) {
        if (category == null || name == null || name.trim().isEmpty()) {
            log.error("Category or name is invalid.");
            throw new IllegalArgumentException("Category or name cannot be null or empty.");
        }
        Product product = new Product(name, category);
        if (products.remove(product)) {
            log.info("Product removed: {} (Category: {})", name, category);
        } else {
            log.warn("Product not found: {} (Category: {})", name, category);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        if (category == null) {
            log.error("Category is invalid.");
            throw new IllegalArgumentException("Category cannot be null.");
        }
        List<Product> productsInCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsInCategory.add(product);
                log.info("Product found: {} (Category: {})", product.getName(), product.getCategory());
            }
        }
        if (productsInCategory.isEmpty()) {
            log.warn("No products found in category: {}", category);
        }
        return productsInCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        var groupedProducts = new HashMap<Category, List<Product>>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        log.info("Grouped products: {}", groupedProducts);
        return groupedProducts;
    }

    public void printAllProducts() {
        var groupedProducts = groupProductsByCategory();
        groupedProducts.forEach((category, products) -> {
            System.out.println("Category: " + category);
            System.out.println("Products:");
            products.forEach(product -> System.out.println(" - " + product.getName()));
            System.out.println();
        });
    }
}