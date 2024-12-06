package school.faang.task_45138.storage;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.task_45138.entity.Product;

public class ProductStorage {
    private static final Logger log = LoggerFactory.getLogger(ProductStorage.class);
    private final HashSet<Product> products = new HashSet<>();

    /**
     * Adds a product to the collection.
     *
     * @param product the product to be added to the collection.
     */
    public void addItem(Product product) {
        boolean isAdded = products.add(product);
        if (isAdded) {
            log.info("Product {} successfully added", product.getName());
        }
        log.info("Failed to add product {}", product.getName());
    }

    /**
     * Removes a product from the collection.
     *
     * @param productToRemove the product to be removed from the collection.
     */
    public void removeItem(Product productToRemove) {
        boolean isRemoved = products.remove(productToRemove);
        if (isRemoved) {
            log.info("Removed product from category: {} and product name: {}",
                    productToRemove.getCategory(), productToRemove.getName());
        }
        log.info("Failed to remove product: {}", productToRemove);
    }

    /**
     * Finds all products in the collection by the specified category.
     *
     * @param category the category of the products to find.
     * @return a list of products that belong to the specified category.
     */
    public List<Product> findItemsByCategory(String category) {
        List<Product> productsFound = products.stream()
                .filter(product -> Objects.equals(product.getCategory(), category))
                .toList();

        if (productsFound.isEmpty()) {
            log.info("No products found in category: {}", category);
        }
        return productsFound;
    }

    /**
     * Prints all products in the collection.
     */
    public void printAllItems() {
        System.out.println("=== All Products ===");

        products.forEach(product ->
                System.out.println(
                        "Category: " + product.getCategory() + ", Name: " + product.getName()
                )
        );

        System.out.println("====================");
    }

    /**
     * Groups products by their category.
     *
     * @param products the set of products to group.
     * @return a map where the key is the product category and the value is a list of products in that category.
     */
    public static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.toList()));
    }

    /**
     * Prints the grouped products by category.
     *
     * @param groupedProducts a map where the key is the product category
     *                       and the value is a list of products in that category.
     */
    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
