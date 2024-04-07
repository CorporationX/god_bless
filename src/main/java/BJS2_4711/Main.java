package BJS2_4711;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Молоко", "Продукты"));
        products.add(new Product(2, "Колбаса", "Продукты"));
        products.add(new Product(3, "Монитор", "Техника"));
        products.add(new Product(4, "Видеокарта", "Техника"));
        products.add(new Product(5, "Стол", "Мебель"));
        products.add(new Product(6, "Стул", "Мебель"));
        printGroupProductByCategory(groupProductByCategory(products));
    }

    private static Map<String, List<Product>> groupProductByCategory(Set<Product> products) {
        Map<String, List<Product>> result = new HashMap<>();
        for (Product product : products) {
            result.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return result;
    }

    private static void printGroupProductByCategory(Map<String, List<Product>> products) {
        for (Map.Entry<String, List<Product>> product : products.entrySet()) {
            System.out.println(product.getKey());
            for (var article : product.getValue()) {
                System.out.println("  " + article);
            }
        }
    }
}
