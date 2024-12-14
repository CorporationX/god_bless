package school.faang.s13task45124;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        WarehouseManagement warehouse = new WarehouseManagement();

        warehouse.addItem(Category.FRUITS, "Orange");
        warehouse.addItem(Category.FRUITS, "Banana");
        warehouse.addItem(Category.VEGETABLES, "Carrot");
        warehouse.printAllItems();
        System.out.println("***");
        warehouse.findItemsByCategory(Category.FRUITS);
        warehouse.removeItem(Category.FRUITS, "Orange");
        System.out.println("***");
        warehouse.printAllItems();

        System.out.println("***");
        Set<Product> products = new HashSet<>(warehouse.getProducts());

        Map<Category, List<Product>> groupedProducts = warehouse.groupProductsByCategory(products);
        warehouse.printProductsByCategory(groupedProducts);
        System.out.println("***");
        warehouse.printAllItems();
    }
}