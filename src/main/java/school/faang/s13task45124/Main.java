package school.faang.s13task45124;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WarehouseManagement warehouse = new WarehouseManagement();

        warehouse.addItem("Fruits", "Orange");
        warehouse.addItem("Fruits", "Banana");
        warehouse.addItem("Vegetables", "Carrot");
        warehouse.printAllItems();
        System.out.println("***");
        warehouse.findItemsByCategory("Fruits");
        warehouse.removeItem("Fruits", "Orange");
        System.out.println("***");
        warehouse.printAllItems();

        System.out.println("***");
        HashSet<Product> products = new HashSet<>(warehouse.getProducts());

        Map<String, List<Product>> groupedProducts = warehouse.groupProductsByCategory(products);
        warehouse.printProductsByCategory(groupedProducts);
        System.out.println("***");
        warehouse.printAllItems();
    }
}