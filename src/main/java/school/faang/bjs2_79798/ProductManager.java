package school.faang.bjs2_79798;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private Set<Product> products = new HashSet<>();

    private static Long countId = 0L;

    public void addProduct(Category category, String name) {
        if (isInvalidCategory(category) || isInvalidName(name)) {
            return;
        }

        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println("This good is exist already");
                return;
            }
        }

        products.add(new Product(generateId(), name, category));
    }

    public boolean removeProduct(Category category, String name) {
        if (isInvalidCategory(category) || isInvalidName(name)) {
            return false;
        }

        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                return products.remove(product);
            }
        }

        return false;
    }

    public List<Product> findProductByCategory(Category category) {
        if (isInvalidCategory(category)) {
            return new ArrayList<>();
        }
        List<Product> productsByCategory = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        }

        return productsByCategory;
    }

    private Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> groupedProduct = new HashMap<>();

        for (Product product : products) {
            groupedProduct.computeIfAbsent(product.getCategory(), key -> new ArrayList<>()).add(product);
        }

        return groupedProduct;
    }

    public void printAllProducts() {
        for (var entry : groupProductsByCategory().entrySet()) {
            System.out.printf("Категория: %s%nПродукты:\n", entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.printf(" - %s%n", product.getName());
            }
            System.out.println();
        }
    }

    private static Long generateId() {
        return countId++;
    }

    private boolean isInvalidCategory(Category category) {
        return category == null;
    }

    private boolean isInvalidName(String name) {
        return name == null || name.isBlank();
    }
}
