package faang.school.godbless.rpg;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Character frodo = new Character("Frodo", new ArrayList<>());
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        System.out.println(frodo.getInventory().size());

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));
        System.out.println(frodo.getInventory());

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        System.out.println(frodo.getInventory().size());
    }
}
