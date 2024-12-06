package school.faang.task_45142;

import java.util.*;

public class Main {
    private static final WarehouseManager warehouseManager = new WarehouseManager();

    public static void main(String[] args) {
        initData();

        warehouseManager.printAllItems();
        System.out.println();

        warehouseManager.findItemsByCategory("Vegetable");
        System.out.println();

        warehouseManager.removeItem("Fruit", "Banana");
        System.out.println();


        Set<Product> products = warehouseManager.getProducts();
        Map<String, List<Product>> productsByCategory = groupProductsByCategory(products);

        printProductsByCategory(productsByCategory);
    }

    private static void initData() {
        warehouseManager.addItem("Fruit", "Apple");
        warehouseManager.addItem("Fruit", "Banana");
        warehouseManager.addItem("Vegetable", "Carrot");
        warehouseManager.addItem("Bakery", "Bread");
        warehouseManager.addItem("Dairy", "Milk");
        warehouseManager.addItem("Meat", "Chicken");
        warehouseManager.addItem("Dairy", "Eggs");
        warehouseManager.addItem("Grains", "Rice");
        warehouseManager.addItem("Vegetable", "Potato");
        warehouseManager.addItem("Vegetable", "Tomato");
    }

    private static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> productsByCategory = new HashMap<>();

        for (Product product : products) {
            productsByCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        return productsByCategory;
    }

    private static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.printf("Category: %s%n", entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.printf("\t- %s%n", product);
            }
        }
    }

}
