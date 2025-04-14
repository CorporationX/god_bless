package school.faang.lord_of_rings;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Item knife = new Item("Knife", 500);
        Item ring = new Item("Ring", 10000000);
        Item cloak = new Item("cloak", 100);
        Item sword = new Item("Sword", 100);
        Item stick = new Item("Stick", 1000000);

        Character frodo = new Character("Frodo", new ArrayList<>(List.of(knife, ring)));
        Character gandalf = new Character("Gandalf", new ArrayList<>(List.of(sword)));

        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addItem(frodo, cloak, item ->
                System.out.println(String.format("New item was added: %s, congratulations!%n", item.getName())));
        inventoryManager.addItem(gandalf, stick, item ->
                System.out.println(String.format("New item was added: %s, congratulations!%n", item.getName())));
        inventoryManager.removeItem(frodo, item -> item.getValue() < 1000);
        inventoryManager.removeItem(gandalf, item -> item.getValue() < 1);
        inventoryManager.updateItem(frodo, item -> {
            item.setValue(item.getValue() + 500);
            return item;
        });

        System.out.println(String.format("Checking inventory after methods call: %s", frodo.getInventory()));
        System.out.println(String.format("Checking inventory after methods call: %s", gandalf.getInventory()));
    }
}
