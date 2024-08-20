package BJS2_21262_LOTR;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Character gandalf = new Character("Gandalf", new ArrayList<>());
        Item ring = new Item("The one Ring", 1000);

        InventoryManager.addItem(gandalf, ring, item -> System.out.println(item.getName() +
                " was added to " + gandalf.getName() + "'s inventory"));
        System.out.println(gandalf.getInventory().get(0).getName());

        InventoryManager.updateItem(gandalf, item -> item.getName().equals("The one Ring"),
                item -> new Item(item.getName(), item.getValue() * 2));
        System.out.println(ring.getValue());

        InventoryManager.removeItem(gandalf, item -> item.getName().equals("The one Ring"));
        System.out.println(gandalf.getInventory());
    }
}
