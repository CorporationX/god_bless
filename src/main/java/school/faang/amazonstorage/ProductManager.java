package school.faang.amazonstorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private static final String PRINT_SET_PRODUCTS_FORMAT = "Id: %d, category: %s, name: %s\n";
    private static final String PRINT_CATEGORY_FORMAT = "Category: %s\n";
    private static final String PRINT_PRODUCT_FORMAT = "- %s\n";

    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);
        groupProductsByCategory();
    }

    public void removeProduct(Category category, String name) {
        categoryMap.get(category).removeIf(product -> product.getName().equals(name));
        products.removeIf(product -> product.getName().equals(name)
                && product.getCategory().equals(category));
    }

    public void findProductsByCategory(Category category) {
        if (categoryMap.containsKey(category)) {
            printProduct(category);
        } else {
            System.out.println("There are no products in the category " + category);
        }
    }

    private void groupProductsByCategory() {
        categoryMap.clear();
        products.forEach(product -> {
            if (categoryMap.containsKey(product.getCategory())) {
                categoryMap.get(product.getCategory()).add(product);
            } else {
                categoryMap.computeIfAbsent(product.getCategory(), key ->
                        new ArrayList<>()).add(product);
            }
        });
    }

    public void printAllProducts() {
        categoryMap.forEach((category, products) -> printProduct(category));
    }

    public void printAllProductsFromSet() {
        products.forEach(product -> System.out.printf(PRINT_SET_PRODUCTS_FORMAT,
                product.getId(), product.getCategory(), product.getName()));
        System.out.println();
    }

    private void printProduct(Category category) {
        System.out.printf(PRINT_CATEGORY_FORMAT, category);
        System.out.println("Products:");
        categoryMap.get(category).forEach(product ->
                System.out.printf(PRINT_PRODUCT_FORMAT, product.getName()));
        System.out.println();
    }
}
