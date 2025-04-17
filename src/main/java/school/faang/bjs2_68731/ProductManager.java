package school.faang.bjs2_68731;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        products.add(new Product(name, category));
    }

    public void removeProduct(Category category, String name) {
        products.remove(new Product(name, category));
    }

    public List<Product> findProductsByCategory(Category category) {
        ArrayList<Product> productsByCategory = new ArrayList<>();

        products.forEach(product -> {
            if (product.getCategory() == category) {
                productsByCategory.add(product);
            }
        });

        return productsByCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productsGroupedByCategory = new EnumMap<>(Category.class);

        for (Category category : Category.values()) {
            productsGroupedByCategory.putIfAbsent(category, findProductsByCategory(category));
        }

        return productsGroupedByCategory;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> productsGroupedByCategory = groupProductsByCategory();

        for (Map.Entry<Category, List<Product>> entry : productsGroupedByCategory.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                System.out.printf("%nКатегория: %s%nПродукты:%n", entry.getKey().name());
                entry.getValue().forEach(
                        product -> System.out.printf("- %s%n", product.getName())
                );
            }
        }
    }
}
