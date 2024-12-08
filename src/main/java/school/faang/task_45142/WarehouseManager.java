package school.faang.task_45142;

import lombok.Getter;

import java.util.*;


public class WarehouseManager {
    private int nextProductId;
    @Getter
    private final Set<Product> products;

    public WarehouseManager(HashSet<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("Products cannot be null");
        }

        this.nextProductId = getLastProductId(products) + 1;
        this.products = products;
    }

    public WarehouseManager() {
        this(new HashSet<>());
    }

    private static int getLastProductId(Set<Product> products) {
        if (products.isEmpty()) {
            return 0;
        }

        int lastProductId = Integer.MIN_VALUE;
        for (Product product : products) {
            lastProductId = Integer.max(lastProductId, product.getId());
        }

        return lastProductId;
    }

    private static void validateCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category cannot be null or blank");
        }
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }

    public void addItem(String category, String name) {
        validateCategory(category);
        validateName(name);

        products.add(new Product(nextProductId++, name.trim(), category.trim()));
    }

    public void removeItem(String category, String name) {
        validateCategory(category);
        validateName(name);

        boolean productFound = false;
        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                if (products.remove(product)) {
                    System.out.printf("%s has been removed successfully.%n", product);
                    productFound = true;
                }
                break;
            }
        }

        if (!productFound) {
            System.out.printf("No product found with name %s in category %s.%n", name, category);
        }
    }

    public void findItemsByCategory(String category) {
        validateCategory(category);

        boolean productsFound = false;
        System.out.printf("%s:%n", category);
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                System.out.printf("\t- %s%n", product);
                productsFound = true;
            }
        }

        if (!productsFound) {
            System.out.println("\tNo products found in this category.");
        }
    }

    public void printAllItems() {
        products.forEach(System.out::println);
    }

}
