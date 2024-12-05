package school.faang.sprint1.taskbjs245082;

import java.util.*;

public class Main {
    private static int productId = 1;
    private static final Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        addItem("phone", "electronics");
        addItem("TV", "electronics");
        addItem("bread", "grossery");
        addItem("PC", "electronics");

        removeItem("electronics", "TV");

        findItemsByCategory("grossery");
        System.out.println("*****");

        printAllItems();
        System.out.println("*****");

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);
        System.out.println(groupedProducts);
        System.out.println("*****");

        printProductsByCategory(groupedProducts);
    }

    private static void addItem(String name, String category) {
        products.add(new Product(productId++, name, category));
    }

    private static void removeItem(String category, String name) {
        if (category.isBlank() || name.isBlank()) {
            throw new IllegalArgumentException("Category or name is empty.");
        }
        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                products.remove(product);
                break;
            }
        }
        //products.removeIf(product -> product.getCategory().equals(category) && product.getName().equals(name));
    }

    private static void findItemsByCategory(String category) {
        if (category.isBlank()) {
            throw new IllegalArgumentException("category is empty!");
        }

        boolean isFounded = false;

        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                System.out.println(product);
                isFounded = true;
            }
        }

        if (!isFounded) {
            System.out.println("There is no such category!");
        }
    }

    private static void printAllItems() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProductsByCategory = new HashMap<>();

        for (Product product : products) {
            groupedProductsByCategory
                    .computeIfAbsent(product.getCategory(), key -> new ArrayList<>())
                    .add(product);
        }

        return groupedProductsByCategory;
    }

    private static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product);
            }
        }
    }
}
