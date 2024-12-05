package school.faang.bjs245128;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

    public static HashSet<Product> products = new HashSet<>();

    public static void main(String[] args) {

    }

    public static void addItem(String category, String name) {
        products.add(createProduct(category, name));
    }

    public static String removeItem(String category, String name) {
        return products.remove(createProduct(category, name)) ? "Product removed from stock" :
                "Fail. Product does not exists in stock";
    }

    public static void printAllItems() {
        products.forEach(System.out::println);
    }

    public static void findItemsByCategory(String category) {
        List<Product> filteredProducts = products.stream()
                .filter(item -> item.getCategory().equals(category))
                .toList();
        if (filteredProducts.isEmpty()) {
            System.out.println("There are no items in stock with this category.");
        } else {
            System.out.println("Products in category '" + category + "':");
            filteredProducts.forEach(System.out::println);
        }
    }

    public static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> result = new HashMap<>();
        for (Product product : products) {
            if (!result.containsKey(product.getCategory())) {
                result.put(product.getCategory(), new ArrayList<>());
            }
            result.get(product.getCategory()).add(product);
        }
        return result;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (var entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("Product: " + product);
            }
        }
    }

    private static Product createProduct(String category, String name) {
        Random random = new Random();
        return new Product(random.nextLong(), name, category);
    }

}
