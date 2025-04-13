package school.faang.parse_the_warehouse_amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public Product addProduct(Category category, String name) {
        Objects.requireNonNull(category, "Category cannot be null");
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        Product newProduct = new Product(name.trim(), category);
        if (!products.add(newProduct)) {
            throw new IllegalStateException("Product already exists: " + name + " in category " + category);
        }
        return newProduct;
    }

    public boolean removeProduct(Category category, String name) {
        Objects.requireNonNull(category, "Category cannot be null");
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        return products.removeIf(p ->
                p.getCategory() == category
                        && p.getName().equalsIgnoreCase(name.trim())
        );
    }

    public List<Product> findProductsByCategory(Category category) {
        Objects.requireNonNull(category, "Category cannot be null");

        return products.stream()
                .filter(p -> p.getCategory() == category)
                .collect(Collectors.toList());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        TreeMap::new,
                        Collectors.toList()
                ));
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();

        if (groupedProducts.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        groupedProducts.forEach((category, productList) -> {
            System.out.println("\nCategory: " + category.getDisplayName());
            System.out.println("Product:");

            productList.stream()
                    .map(Product::getName)
                    .sorted()
                    .forEach(name -> System.out.println("- " + name));
        });
    }
}
