package faang.school.godbless.lord_of_the_rings;

import faang.school.godbless.lord_of_the_rings.model.Character;
import faang.school.godbless.lord_of_the_rings.model.InventoryManager;
import faang.school.godbless.lord_of_the_rings.model.Item;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item sword = new Item("Anduril", 500);

        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to inventory."));
        inventoryManager.addItem(frodo, sword, (item) -> System.out.println(item.getName() + " was added to inventory."));
        System.out.println(frodo);

        inventoryManager.removeItem(frodo, (item) -> item.getName().equals("Anduril"));
        System.out.println(frodo);

        inventoryManager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        System.out.println(frodo);
    }
}
