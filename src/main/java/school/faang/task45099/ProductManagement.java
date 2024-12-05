package school.faang.task45099;

import java.util.*;

public class ProductManagement {

    private static final Map<String, List<Product>> PRODUCTS_BY_CATEGORY = new HashMap<>();

    public ProductManagement() {
        generateData();
    }

    private static void generateData() {
        Set<String> categoryKeys = Set.of("Meat products", "Milk products", "Vegetables");
        Set<Product> products = Set.of(
                new Product(1, "Meat", "Meat products"),
                new Product(2, "Milk", "Milk products"),
                new Product(3, "Milk", "Milk products"),
                new Product(4, "Salad", "Vegetables")
        );

        for (var category : categoryKeys) {
            PRODUCTS_BY_CATEGORY.putIfAbsent(category, new ArrayList<>());
            for (var product : products) {
                if (category.equals(product.getCategory())) {
                    PRODUCTS_BY_CATEGORY.get(category).add(product);
                }
            }
        }
    }

    private void validation(String category, String nameProduct) {
        if (category == null || nameProduct == null) {
            throw new IllegalArgumentException("Category and name cannot be null");
        }
    }

    private void findCategory(String category) {
        if (!PRODUCTS_BY_CATEGORY.containsKey(category)) {
            throw new IllegalArgumentException("There is no such category.");
        }
    }

    public void addItem(int id, String nameProduct, String category) {
        validation(category, nameProduct);

        PRODUCTS_BY_CATEGORY.putIfAbsent(category, new ArrayList<>());

        List<Product> productCategory = PRODUCTS_BY_CATEGORY.get(category);
        Product product = new Product(id, nameProduct, category);

        if (productCategory.contains(product)) {
            throw new IllegalArgumentException("The product has already been successfully added to the category.");
        } else {
            productCategory.add(product);
            System.out.println("The product has been successfully added to the category.");
        }
    }

    public void removeItem(int id, String nameProduct, String category) {
        validation(category, nameProduct);

        List<Product> products = PRODUCTS_BY_CATEGORY.get(category);
        Product product = new Product(id, nameProduct, category);

        findCategory(category);

        if (!products.remove(product)) {
            throw new IllegalArgumentException("There is no such product.");
        } else {
            System.out.println("The product has been successfully deleted.");
        }

    }

    public void findItemsByCategory(String category) {
        findCategory(category);
        PRODUCTS_BY_CATEGORY.get(category).forEach(System.out::println);
    }

    public void printAllItems() {
        if (PRODUCTS_BY_CATEGORY.isEmpty()) {
            throw new IllegalArgumentException("There is no such category.");
        }
        PRODUCTS_BY_CATEGORY.forEach((key, value) -> System.out.println(key + ": " + value));
    }

}
