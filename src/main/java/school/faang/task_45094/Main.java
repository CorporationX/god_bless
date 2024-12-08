package school.faang.task_45094;

import java.util.*;

public class Main {
    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(" " + product.getName());
            }
        }
    }

    public static void main(String[] args) {
        Set<Product> productSet = new HashSet<>();
        productSet.add(new Product(1, "Молоко", "Продукты"));
        productSet.add(new Product(2, "Хлеб", "Продукты"));
        productSet.add(new Product(3, "Мыло", "Бытовая химия"));
        productSet.add(new Product(4, "Шампунь", "Бытовая химия"));

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(productSet);

        printProductsByCategory(groupedProducts);

        var productService = new ProductService(groupedProducts);

        productService.addItem("Мебель", 5, "Диван");

        productService.printAllItems();

        productService.removeItem("Продукты", "Хлеб");

        productService.printAllItems();

        productService.findItemsByCategory("Бытовая химия");
    }
}