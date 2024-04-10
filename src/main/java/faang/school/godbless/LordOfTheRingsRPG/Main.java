package faang.school.godbless.LordOfTheRingsRPG;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Item ring = new Item("The One Ring", 1000);
        Item shield = new Item("Shield", 1000);

        Character frodo = new Character(List.of(ring));

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        manager.addItem(frodo, shield, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));

        System.out.println(frodo.inventory());

    }
}