package ru.kraiush.BJS2_33640;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Character bilbo = new Character(new ArrayList<>());

        InventoryManager inventoryManager = new InventoryManager();

        Item ring1 = new Item("Ring", 100);
        Item ring2 = new Item("Ring", 50);
        Item sword = new Item("Sword", 800);

        inventoryManager.addItem(bilbo, ring1, item -> System.out.println(item.getName() + " was added to the character's inventories."));
        inventoryManager.addItem(bilbo, ring2, item -> System.out.println(item.getName() + " was added to the character's inventories."));
        inventoryManager.addItem(bilbo, sword, item -> System.out.println(item.getName() + " was added to the character's inventories."));

        inventoryManager.removeItem(bilbo, item -> item.getValue() < 100);

        inventoryManager.updateItem(bilbo, item -> item.getName().equals("Ring"), item -> new Item(item.getName(), item.getValue() * 2));

        bilbo.getInventories().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
