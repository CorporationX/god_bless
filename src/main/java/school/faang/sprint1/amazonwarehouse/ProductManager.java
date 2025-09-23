package school.faang.sprint1.amazonwarehouse;

import java.util.List;
import java.util.Map;

public interface ProductManager {

    /**
     * Adds a new product.
     *
     * @param category the category od a product
     * @param name     the product name
     * @return the created product
     */
    Product addProduct(Category category, String name);

    /**
     * Removes product by category AND name.
     *
     * @param category the category of a product
     * @param name     the product name
     * @return true if product removed, false of not found
     */
    boolean removeProduct(Category category, String name);

    /**
     * Finds all products in certain category.
     *
     * @param category the category of products to search in
     * @return list of products in that category.
     */
    List<Product> findProductsByCategory(Category category);

    /**
     * Groups all products by category.
     *
     * @return map of category to list of products
     */
    Map<Category, List<Product>> groupProductsByCategory();

    /**
     * Prints all product grouped by category
     */
    void printAllProducts();
}
