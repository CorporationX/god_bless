package school.faang.amazonwarehouse;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Create a HashSet of Products
        Set<Product> products = new HashSet<>();

        // Add products to the HashSet
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Smartphone", "Electronics"));
        products.add(new Product(3, "T-shirt", "Clothing"));
        products.add(new Product(4, "Jeans", "Clothing"));
        products.add(new Product(5, "Blender", "Home Appliances"));
        products.add(new Product(6, "Toaster", "Home Appliances"));

        // Group products by category
        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);

        // Print the grouped products by category
        printGroupedProducts(groupedProducts);
    }

    // Method to group products by category using HashMap
    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> productMap = new HashMap<>();

        // Iterate through the HashSet of products
        for (Product product : products) {
            String category = product.getCategory();

            // If the category does not exist in the map, add a new list
            productMap.putIfAbsent(category, new ArrayList<>());

            // Add the product to the list corresponding to its category
            productMap.get(category).add(product);
        }

        return productMap;
    }
