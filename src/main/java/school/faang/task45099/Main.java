package school.faang.task45099;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            ProductManagement pm = new ProductManagement();
            pm.printAllItems();
            pm.findItemsByCategory("Milk products");
            pm.removeItem(3, "Milk", "Milk products");
            pm.addItem(6, "Toy", "Toys");
            pm.printAllItems();
            List<Product> productsList = pm.getProductsByCategory().get("Milk products");
            Set<Product> products = new HashSet<>(productsList);
            printProductsByCategory(groupProductsByCategory(products));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        if (products.isEmpty()) {
            throw new IllegalArgumentException("The list is empty.");
        }
        Map<String, List<Product>> productsByCategory = new HashMap<>();

        for (Product product : products) {
            productsByCategory.putIfAbsent(product.getCategory(), new ArrayList<>());
            productsByCategory.get(product.getCategory()).add(product);
        }

        return productsByCategory;
    }

    public static void printProductsByCategory(Map<String, List<Product>> products) {
        if (products.isEmpty()) {
            throw new IllegalArgumentException("This map is empty.");
        }
        products.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
