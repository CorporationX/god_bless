package school.faang.bjs2_85972.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import school.faang.bjs2_85972.exception.EmptyStockException;
import school.faang.bjs2_85972.exception.ProductNotFoundException;
import school.faang.bjs2_85972.product.Product.Category;

public class ProductManager {
    private static final Set<Product> STOCK = new HashSet<>();

    private ProductManager() {

    }

    public static void addProduct(Category category, String name) {
        if (category == null) {
            throw new IllegalArgumentException("category cannot be null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("product name cannot be null, empty or a space");
        }
        STOCK.add(new Product(name, category));
    }

    public static void removeProduct(Category category, String name) {
        checkForStockSize();
        Product deletedProduct = new Product(name, category);
        if (!STOCK.contains(deletedProduct)) {
            Product.decreaseCounter();
            throw new ProductNotFoundException("there is no such product in stock");
        }
        STOCK.remove(deletedProduct);
        Product.decreaseCounter();
    }

    public static List<Product> findProductsByCategory(Category category) {
        checkForStockSize();
        if (category == null) {
            throw new IllegalArgumentException("category cannot be null");
        }

        List<Product> foundByCategory = new ArrayList<>();
        for (Product product : STOCK) {
            if (product.getCategory() == category) {
                foundByCategory.add(product);
            }
        }

        if (foundByCategory.isEmpty()) {
            throw new ProductNotFoundException("there aren't any products in the stock with such category");
        }
        return foundByCategory;
    }

    public static Map<Category, List<Product>> groupProductsByCategory() {
        checkForStockSize();
        Map<Category, List<Product>> groupedByCategory = new HashMap<>();
        for (Product product : STOCK) {
            groupedByCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedByCategory;
    }

    public static void printAllProducts() {
        checkForStockSize();
        Map<Category, List<Product>> groupedByCategory = groupProductsByCategory();
        groupedByCategory.forEach((category, products) -> {
            System.out.println("Category: " + category + "\nProducts: ");
            for (Product product : products) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        });
    }

    private static void checkForStockSize() {
        if (STOCK.isEmpty()) {
            throw new EmptyStockException("the stock is empty yet");
        }
    }
}
