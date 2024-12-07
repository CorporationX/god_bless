package school.faang.task_45149;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        WarehouseSystem warehouseSystem = new WarehouseSystem();

        warehouseSystem.addItem("mobile", "iphone");
        warehouseSystem.addItem("mobile", "samsung");
        warehouseSystem.addItem("mobile", "huawei");
        warehouseSystem.addItem("tv", "sber");
        warehouseSystem.addItem("tv", "samsung");

        warehouseSystem.printAllItems();

        warehouseSystem.removeItem("mobile", "samsung");
        warehouseSystem.removeItem("notebook", "acer");
        warehouseSystem.removeItem("tv", "lg");
        warehouseSystem.removeItem("mobile", "iphone");

        warehouseSystem.printAllItems();

        warehouseSystem.findItemsByCategory("tv");
        warehouseSystem.findItemsByCategory("mobile");
        warehouseSystem.findItemsByCategory("notebook");

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(warehouseSystem.products);
        printProductsByCategory(groupedProducts);
    }

    public static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        System.out.println("\nВсе товары по категориям:");
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product);
            }
        }
        System.out.println();
    }
}
