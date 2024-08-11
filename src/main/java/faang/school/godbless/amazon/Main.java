package faang.school.godbless.amazon;

import java.util.*;

public class Main {
    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        products.add(new Product(1, "Apple", "Fruits"));
        products.add(new Product(2, "Banana", "Fruits"));
        products.add(new Product(3, "Carrot", "Vegetables"));
        products.add(new Product(4, "Broccoli", "Vegetables"));
        products.add(new Product(5, "Milk", "Dairy"));
        products.add(new Product(6, "Cheese", "Dairy"));

        printProductsByCategory(groupProductsByCategory(products));

        System.out.println("________________________");

        products.add(new Product(6, "Steak", "Butchery"));

        printProductsByCategory(groupProductsByCategory(products));
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> productList) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : productList) {
            String category = product.getCategory();

           groupedProducts.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> productsByCategory) {
        for (Map.Entry<String, List<Product>> entry : productsByCategory.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(" |_ " + product);
            }
        }
    }

}
