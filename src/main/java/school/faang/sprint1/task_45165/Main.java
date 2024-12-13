package school.faang.sprint1.task_45165;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        HashSet<Product> products = new HashSet<>();
        products.add(new Product(1, "Apple", "Fruits"));
        products.add(new Product(2, "Bannana", "Fruits"));
        products.add(new Product(3, "Broccoli", "Vegetables"));
        products.add(new Product(4, "Cucumber", "Vegetables"));
        products.add(new Product(5, "Flour", "Cereal"));
        products.add(new Product(6, "Milk", "Dairy"));
        printProductsByCategory(groupProductsByCategory(products));
        groupProductsByCategory(products);


    }

    public static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            String category = product.getCategory();
            groupedProducts.putIfAbsent(category, new ArrayList<>());
            groupedProducts.get(category).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            String category = entry.getKey();
            List<Product> products = entry.getValue();
            System.out.println("Category: " + category);
            for (Product product : products) {
                System.out.println("  " + product);
            }
        }
    }

}
