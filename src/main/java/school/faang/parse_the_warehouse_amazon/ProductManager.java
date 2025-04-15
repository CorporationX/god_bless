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

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
    }

    public Product addProduct(Category category, String name) {
        String trimmedName = name.trim();
        Objects.requireNonNull(category, "Category cannot be null");
        if (trimmedName.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        Product newProduct = new Product(trimmedName, category);
        if (!products.add(newProduct)) {
            throw new IllegalStateException("Product already exists: " + name + " in category " + category);
        }
        return newProduct;
    }

    public boolean removeProduct(Category category, String name) {
        String trimmedName = name.trim();
        Objects.requireNonNull(category, "Category cannot be null");
        validateName(trimmedName);
        {
            return products.removeIf(product ->
                    product.getCategory() == category
                            && product.getName().equalsIgnoreCase(trimmedName)
            );
        }
    }
    public List<Product> findProductsByCategory(Category category) {
        Objects.requireNonNull(category, "Category cannot be null");

        return products.stream()
                .filter(product -> product.getCategory() == category)
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
