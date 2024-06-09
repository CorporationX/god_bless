package faang.school.godbless.task9;

import java.util.*;

public class Main {
    public static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        products.addAll(new ArrayList<>(Arrays.asList(new Product(1, "1", "2"),
                new Product(3, "1", "1"),
                new Product(2, "2", "2"),
                new Product(4, "5", "1"))));
        groupProducts(products);
        printProductsByCategory(groupProducts(products));
    }

    public static Map<String, List<Product>> groupProducts(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> productCategories) {
        for (Map.Entry<String, List<Product>> entry : productCategories.entrySet()) {
            String category = entry.getKey();
            List<Product> products = entry.getValue();

            System.out.println("Category: " + category + "\nProducts: " + products + "\n");
        }
    }

}
