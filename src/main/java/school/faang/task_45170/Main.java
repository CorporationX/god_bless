package school.faang.task_45170;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        ProductSystem productSystem = new ProductSystem();

        productSystem.addItem(1, "Apple", "Fruits");
        productSystem.addItem(2, "Banana", "Fruits");
        productSystem.addItem(3, "Carrot", "Vegetables");
        productSystem.addItem(4, "Broccoli", "Vegetables");
        productSystem.addItem(5, "Milk", "Dairy");
        productSystem.printAllItems();
        productSystem.findItemsByCategory("Vegetables");
        productSystem.removeItem(6, "Orange", "Fruits");
        productSystem.printAllItems();

        Map<String, Set<Product>> grouped = ProductSystem.groupProductsByCategory(products);
        ProductSystem.printProductsByCategory(grouped);
    }
}