package lord.of.the.rings;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Item> inventory = new ArrayList<>();
        inventory.add(new Item("Helmet", 500));
        inventory.add(new Item("Shield", 1200));
        inventory.add(new Item("Spoon", 20));

        Character frodo = new Character("Frodo", inventory);
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(frodo, new Item("Gun", 10000));
        inventoryManager.removeItem(frodo, item -> item.getName().equals("Spoon"));

        Predicate<Item> predicate = item -> item.getValue() < 1000;
        Consumer<Item> consumer = item -> item.setValue(item.getValue() * 2);
        inventoryManager.updateItem(frodo, predicate, consumer);

        for (Item item : frodo.getInventory()) {
            System.out.printf("%s s item with name: %s and value %s%n", frodo.getName(),
                    item.getName(),
                    item.getValue());
        }
    }
}
