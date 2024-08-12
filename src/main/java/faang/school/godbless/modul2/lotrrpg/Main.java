package faang.school.godbless.modul2.lotrrpg;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Character frodo = new Character("Frodo", new ArrayList<>());
        Item ring = new Item("The One Ring", 1000);


        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.showInventory(frodo);

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) ->
                new Item(item.getName(), item.getValue() * 2));
        manager.showInventory(frodo);

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        manager.showInventory(frodo);
    }
}
