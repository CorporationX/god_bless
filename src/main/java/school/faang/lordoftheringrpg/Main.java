package school.faang.lordoftheringrpg;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();

        InventoryManager inventoryManager = new InventoryManager();

        // add items
        inventoryManager.addItem(new Item("The One Ring", 1000),items::add);
        inventoryManager.addItem(new Item("Elrond Sword", 50000), items::add);

        // remove item
        inventoryManager.removeItem(items, item -> item.getPrice() > 20000);
        System.out.println("After removing: " + items);

        // update item
        inventoryManager.updateItem(new Item("The One Ring", 1000), items, item -> {
            item.setName("Aragorn crown");
            item.setPrice(1000000);
            return item;
        });

        System.out.println("Item updated: " + items);


    }
}
