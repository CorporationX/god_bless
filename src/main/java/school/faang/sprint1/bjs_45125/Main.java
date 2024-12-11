package school.faang.sprint1.bjs_45125;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InventoryManagement warehouse = new InventoryManagement();

        warehouse.addItem("TV", "electronics");
        warehouse.addItem("dress", "cloth");
        warehouse.addItem("iPhone15", "electronics");
        warehouse.addItem("butter", "food");
        warehouse.addItem("meat", "food");

        warehouse.printItemsByCategory("food");
        System.out.println();
        System.out.println("----------------");
        warehouse.printAllItems();

        warehouse.addItem("skirt", "cloth");
        warehouse.removeItem("dress", "cloth");
        System.out.println();
        System.out.println("--------##--------");
        List<Product> foodList = warehouse.findItemsByCategory("cloth");
        System.out.println(foodList);
        System.out.println("----------------");
    }

}
