package school.faang.bjs245603.programm;

import school.faang.bjs245603.model.Character;
import school.faang.bjs245603.model.Item;
import school.faang.bjs245603.service.InventoryManager;

public class Main {
    public static void main(String[] args) {
        Item ring = new Item("The One Ring", 1000);
        Item goldRing = new Item("The Gold Ring", 100000);
        Item sword = new Item("The Sword", 10000);
        Item helm = new Item("The Helm", 50);
        Character frodo = new Character("Frodo");

        InventoryManager.add(frodo, ring, (item) -> System.out.println(item.name() + " is added"));
        InventoryManager.add(frodo, goldRing, (item) -> System.out.println(item.name() + " is added"));
        InventoryManager.add(frodo, sword, (item) -> System.out.println(item.name() + " is added"));
        InventoryManager.add(frodo, helm, (item) -> System.out.println(item.name() + " is added"));

        InventoryManager.remove(frodo, item -> item.name().contains("Ring"));
        InventoryManager.update(frodo, item -> item.name().contains("Helm"), item -> new Item(item.name(), 100));

        System.out.println(frodo.getInventory());
    }
}
