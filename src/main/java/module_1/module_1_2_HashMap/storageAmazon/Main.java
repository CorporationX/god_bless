package module_1.module_1_2_HashMap.storageAmazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, List<Product>> CATEGORY_PRODUCTS = new HashMap<>();
    private static final Set<Product> PRODUCTS = new HashSet<>();

    public static void main(String[] args) {

        PRODUCTS.add(new Product("Laptop", "Electronics"));
        PRODUCTS.add(new Product("Headphones", "Electronics"));
        PRODUCTS.add(new Product("Audi","Automobile"));
        PRODUCTS.add(new Product("VW","Automobile"));
        PRODUCTS.add(new Product("Master and Margarita","Book"));
        PRODUCTS.add(new Product("The Great Gatsby","Video"));

        groupingProductsByCategory(PRODUCTS);
        printProductsByCategory();
    }

    public static void groupingProductsByCategory(Set<Product> products) {
        for(Product product: products) {
            String category = product.getCategory();
            if (CATEGORY_PRODUCTS.containsKey(category) && CATEGORY_PRODUCTS.get(category).contains(product)) continue;
            CATEGORY_PRODUCTS.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        }
    }

    public static void printProductsByCategory() {
        for (Map.Entry<String, List<Product>> entry : CATEGORY_PRODUCTS.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product.toString());
            }
        }
    }
}
