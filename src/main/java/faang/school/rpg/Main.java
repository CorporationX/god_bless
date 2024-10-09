package faang.school.rpg;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        Item grindstone = new Item("Grindstone", 500);
        Item batWing = new Item("Bat wing", 350);
        Item spoon = new Item("Old metal spoon", 100);
        Item eye = new Item("Spider's eye", 1000);

        Character elrond = new Character("Elrond", new ArrayList<>());

        inventoryManager.addItem(elrond, grindstone, (item) -> System.out.println("Item " + item.getName() +
                " added to " + elrond.getName() + "'s" + " inventory."));

        inventoryManager.addItem(elrond, eye, (item) -> System.out.println("Item " + item.getName() +
                " added to " + elrond.getName() + "'s" + " inventory."));

        inventoryManager.addItem(elrond, spoon, (item) -> System.out.println("Item " + item.getName() +
                " added to " + elrond.getName() + "'s inventory."));

        inventoryManager.addItem(elrond, batWing, (item) -> System.out.println("Item " + item.getName() +
                " added to " + elrond.getName() + "'s" + " inventory."));

        inventoryManager.removeItem(elrond, (item) -> item.getName().equals("Spider's eye"));

        inventoryManager.updateItem(elrond, (item) -> item.getName().equals("Grindstone"), (item) ->
                new Item(item.getName(), item.getValue() * 2));

        inventoryManager.updateItem(elrond, (item) -> item.getName().equals("Bat wing"), (item) -> new Item(item.getName(), item.getValue() * 4));

        elrond.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
