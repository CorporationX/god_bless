package school.faang.sorting_out_amazons_warehouse.BJS2_56958;

import lombok.Data;
import lombok.NonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class ProductManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductManager.class);

    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private int id = 0;

    public void addProduct(@NonNull Category category, @NonNull String name) {
        validateName(name);

        int uniqueId = id + 1;
        Product product = new Product(uniqueId, name, category);
        products.add(product);
        categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(product);

        LOGGER.info("Added product {} to category {}", uniqueId, category);
    }

    public void removeProduct(@NonNull Category category, @NonNull String name) {
        validateName(name);
        validateCategory(category);

        Product product = new Product(name, category);
        if (!products.contains(product)) {
            LOGGER.error("Product {} does not exist", product);
            throw new IllegalArgumentException("Product " + product + " does not exist");
        }

        products.remove(product);
        categoryMap.get(category).remove(product);

        LOGGER.info("Removed product {} from category {}", name, category);
    }

    public List<Product> findProductsByCategory(@NonNull Category category) {
        validateCategory(category);

        LOGGER.info("Returns a list of all products in the {}", category);

        return categoryMap.computeIfAbsent(category, k -> new ArrayList<>());
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (var product : products) {
            addProduct(product.category(), product.name());
        }

        LOGGER.info("Update {}", categoryMap);
    }

    public void printAllProducts() {
        for (var category : categoryMap.keySet()) {
            System.out.println("Категория: " + category + "\nПродукты: ");
            for (var product : categoryMap.get(category)) {
                System.out.println("- " + product.name());
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
