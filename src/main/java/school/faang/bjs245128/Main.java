package school.faang.bjs245128;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Main {

    public static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {

    }

    public static void addItem(String category, String name) {
        products.add(Product.create(category, name));
    }

    public static String removeItem(String category, String name) {
        return products.remove(Product.create(category, name)) ? "Product removed from stock" :
                "Fail. Product does not exists in stock";
    }

    public static void printAllItems() {
        products.forEach(System.out::println);
    }

    public static void findItemsByCategory(String category) {
        List<Product> filteredProducts = products.stream()
                .filter(item -> Objects.equals(item.getCategory(), category))
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
            result.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
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

}
