package school.faang.amazon;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class ProductManager {

    private static final Set<Product> PRODUCTS = new HashSet<>();
    private static Integer LAST_ID = 0;

    public static void addProduct(@NonNull Category category, @NonNull String name) {
        var id = LAST_ID++;
        var product = new Product(id, name, category);
        PRODUCTS.add(product);
    }

    public static void removeProduct(@NonNull Category category, @NonNull String name) {
        var isRemoved = PRODUCTS.removeIf(product -> product.getName().equals(name)
                && product.getCategory().equals(category));
        if (isRemoved) {
            System.out.printf("Product with name = '%s' and category = '%s' removed\n", name, category);
        }
    }

    public static List<Product> findProductsByCategory(@NonNull Category category) {
        var products = new ArrayList<Product>() {};
        for (var product : PRODUCTS) {
            if (product.getCategory().equals(category)) {
                products.add(product);
            }
        }
        return products;
    }

    public static Map<Category, List<Product>> groupProductsByCategory() {
        return PRODUCTS.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public static void printAllProducts() {
        var productsByCategory = groupProductsByCategory();
        for (var entry : productsByCategory.entrySet()) {
            System.out.printf("Категория: %s\n", entry.getKey());
            System.out.println("Продукты:");
            for (var product : entry.getValue()) {
                System.out.printf("- %s\n", product.getName());
            }
            System.out.println();
        }
    }
}
