package bjs287272;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo", new ArrayList<>());
        Item ring = new Item("The One Ring", 1000);
        Item gold = new Item("The Gold", 900);

        InventoryManager manager = new InventoryManager();

        manager.addItem(ring, frodo, item -> System.out.println("The One Ring is added!"));
        manager.addItem(gold, frodo, item -> System.out.println("The Gold is added!"));

        manager.removeItem(frodo, item -> item.getName().contains("Gold"));

        manager.updateItem(frodo, item -> item.getName().equals("The One Ring"), item -> new Item(item.getName(),
                item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println("\n" + item.getName() + ": " + item.getValue()));
    }
}
