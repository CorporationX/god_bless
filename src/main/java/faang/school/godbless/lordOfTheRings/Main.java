package faang.school.godbless.lordOfTheRings;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Item ring = new Item("The One Ring", 1000);
        List<Item> frodoItems = new ArrayList<>();
        frodoItems.add(ring);
        Character frodo = new Character("Frodo", frodoItems);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
    }
}