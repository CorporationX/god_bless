package school.faang.bjs268676;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.remove(product);
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsInCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                productsInCategory.add(product);
            }
        }
        return productsInCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productsByCategory = new HashMap<>();
        for (Product product : products) {
            productsByCategory
                    .computeIfAbsent(product.getCategory(), k -> new ArrayList<>())
                    .add(product);
        }
        return productsByCategory;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> productsByCategory = groupProductsByCategory();
        productsByCategory.forEach((category, products) -> {
            System.out.println("Category: " + category);
            System.out.println("Products:");
            for (Product product : products) {
                System.out.println(" - " + product.getName());
            }
            System.out.println();
        });
    }
}