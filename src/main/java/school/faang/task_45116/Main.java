package school.faang.task_45116;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addItem(Category.CLOTHING, "T-shirt");
        productManager.addItem(Category.CLOTHING, "Jeans");
        productManager.addItem(Category.FOOD, "Apple");
        productManager.addItem(Category.ELECTRONICS, "Laptop");
        productManager.addItem(Category.ELECTRONICS, "Smartphone");

        productManager.removeItem(Category.CLOTHING, "T-shirt");

        System.out.println("All items:");
        productManager.printAllItems();

        System.out.println("\nItems in Clothing category:");
        productManager.findItemsByCategory(Category.CLOTHING);

        Map<Category, Set<Product>> groupedProducts = productManager.groupProductsByCategory();
        System.out.println("\nGrouped products:");
        groupedProducts.forEach((category, products) -> {
            System.out.println(category + ":");
            products.forEach(System.out::println);
        });
    }
}