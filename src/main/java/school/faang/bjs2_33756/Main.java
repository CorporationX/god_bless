package school.faang.bjs2_33756;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo", new ArrayList<>());
        Item sword = new Item("Sword \"Sting\"", 10_000, 1);

        Character legolas = new Character("Legolas", new ArrayList<>());
        Item bow = new Item("Bow of the Galadhrim", 1_000, 1);
        Item arrow = new Item("Arrows", 300, 10);

        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(frodo, sword, item -> System.out.println("Item " + item.getName() + " add to inventory"));
        inventoryManager.addItem(legolas, bow, item -> System.out.println("Item " + item.getName() + " add to inventory"));
        inventoryManager.addItem(legolas, arrow, item -> System.out.println("Item " + item.getName() + " add to inventory"));

        inventoryManager.removeItem(legolas, item -> item.getQuantity() == 0);

        inventoryManager.updateItem(
                frodo,
                item -> item.getName().equals("Sword \"Sting\""),
                updItem -> new Item(updItem.getName(), updItem.getValue() * 2, 1)
        );
    }
}
