package school.faang.sorting_out_amazons_warehouse.BJS2_56958;

import lombok.NonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductManager.class);

    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(@NonNull Category category, @NonNull String name) {
        validateName(name);

        Product product = new Product(name, category);
        products.add(product);
        categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);

        LOGGER.info("Added product category {}", category);
    }

    public void removeProduct(@NonNull Category category, @NonNull String name) {
        validateName(name);

        Product productToRemove = null;
        for (Product p : products) {
            if (p.getName().equals(name) && p.getCategory().equals(category)) {
                productToRemove = p;
            }
        }

        if (productToRemove == null) {
            LOGGER.info("Removed product category {}", category);
            throw new IllegalArgumentException("Product " + name + " does not exist");
        }
        products.remove(productToRemove);

        if (categoryMap.containsKey(category)) {
            List<Product> productList = categoryMap.get(category);
            productList.remove(productToRemove);

            LOGGER.info("Removed product");

            if (productList.isEmpty()) {
                categoryMap.remove(category);
            }

            LOGGER.info("Removed product category {}", category);
        }

    }

    public List<Product> findProductsByCategory(@NonNull Category category) {
        validateCategory(category);

        LOGGER.info("Returns a list of all products in the {}", category);

        return categoryMap.computeIfAbsent(category, k -> new ArrayList<>());
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (var product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        LOGGER.info("Update {}", categoryMap);
    }

    public void printAllProducts() {
        for (var category : categoryMap.keySet()) {
            System.out.println("Категория: " + category + "\nПродукты: ");
            for (var product : categoryMap.get(category)) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        }
        LOGGER.info("Print all products");
    }

    private static void validateName(String name) {
        if (name.isBlank()) {
            LOGGER.error("Name cannot be blank");
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    private void validateCategory(Category category) {
        if (!categoryMap.containsKey(category)) {
            LOGGER.error("Category {} does not exist", category);
            throw new IllegalArgumentException("Category " + category + " does not exist");
        }
    }
}
