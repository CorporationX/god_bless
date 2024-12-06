package school.faang.amazonstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashSet<Product> products = new HashSet<>();
        products.add(new Product(1, "Apple", "Fruits"));
        products.add(new Product(2, "Carrot", "Vegetables"));
        products.add(new Product(3, "Banana", "Fruits"));
        products.add(new Product(4, "Broccoli", "Vegetables"));
        products.add(new Product(5, "Milk", "Dairy"));

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);
        printProductsByCategory(groupedProducts);

    }

    public static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.printf("К категории %s относятся следующие продукты: ", entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.print(product.getName() + " ");
            }
            System.out.println();
        }
    }
}
