package lord.of.the.rings.rpg;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo", new ArrayList<>());
        Item ring = new Item("Ring", 50);
        Item sword = new Item("Sword", 1000);
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " has been added to the inventory"));
        inventoryManager.addItem(frodo, sword, (item) -> System.out.println(item.getName() + " has been added to the inventory"));

        inventoryManager.removeItem(frodo, (item) -> item.getName().equals("Sword"));

        inventoryManager.updateItem(frodo, (item) -> item.getName().equals("Ring"), (item) -> new Item(item.getName(), item.getValue() * 3));

        frodo.getInventory().forEach(item -> System.out.println("Name: " + item.getName() + " | Value: " + item.getValue()));
    }
}
