package school.faang.task_45138.storage;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.task_45138.entity.CategoryType;
import school.faang.task_45138.entity.Product;

public class ProductStorage {
    private static final Logger log = LoggerFactory.getLogger(ProductStorage.class);
    private final HashSet<Product> products = new HashSet<>();


    public void addItem(Product product) throws IllegalArgumentException {
        boolean isAdded = products.add(product);
        if (!isAdded) {
            throw new IllegalStateException("Failed to add product");
        }
        log.info("Product {} successfully added", product.getName());
    }


    public void removeItem(Product productToRemove) throws IllegalArgumentException {
        boolean isRemoved = products.remove(productToRemove);
        if (!isRemoved) {
            throw new RuntimeException("Failed to remove product " + productToRemove.getName());
        }
        log.info("Removed product from category: {} and product name: {}",
                productToRemove.getCategory(), productToRemove.getName());
    }


    public List<Product> findItemsByCategory(CategoryType category) {
        List<Product> productsFound = products.stream()
                .filter(product -> Objects.equals(product.getCategory(), category))
                .toList();

        if (productsFound.isEmpty()) {
            throw new IllegalStateException("Failed to find product by category " + category);
        }
        return productsFound;
    }


    public void printAllItems() {
        System.out.println("=== All Products ===");

        products.forEach(product ->
                System.out.println("Category: " + product.getCategory() + ", Name: " + product.getName())
        );

        System.out.println("====================");
    }

    /**
     * Groups products by their category.
     *
     * @param products the set of products to group.
     * @return a map where the key is the product category and the value is a list of products in that category.
     */
    public static Map<CategoryType, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.toList()));
    }

    public void printProductsByCategory(Map<CategoryType, List<Product>> groupedProducts) {
        groupedProducts.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
