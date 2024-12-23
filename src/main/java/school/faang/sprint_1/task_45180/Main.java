package school.faang.sprint_1.task_45180;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductService();

        productService.addItem("Электроника", "Ноутбук");
        productService.addItem("Электроника", "Наушники");
        productService.addItem("Музыкальные инструменты", "Гитара");
        productService.addItem("Музыкальные инструменты", "Саксофон");

        productService.printAllItems();

        Map<String, List<Product>> groupedProducts = productService.groupProductsByCategory();

        printProductsByCategory(groupedProducts);
        System.out.println("Удаляем продукт Гитара:");
        productService.removeItem("Музыкальные инструменты", "Гитара");
        productService.printAllItems();
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        if (groupedProducts.isEmpty()) {
            System.out.println("Не найдена категория");
        } else {
            System.out.println("Продукт по категориям:");
            for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
                System.out.println("Категория:\n" + entry.getKey());
                entry.getValue().forEach(product -> System.out.println("  " + product));
            }
        }
    }
}
