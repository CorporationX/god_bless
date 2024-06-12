package faang.school.godbless.rpg;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo", new ArrayList<>());
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " was added to the inventory."));

        var maybeItem = manager.updateItem(frodo,
                (item) -> item.name().equals("The One Ring"),
                (item) -> new Item(item.name(), item.value() * 2));
        System.out.println(maybeItem.isPresent());

        var result = manager.removeItem(frodo, (item) -> item.name().equals("The One Ring"));
        System.out.println(result);
    }
}
