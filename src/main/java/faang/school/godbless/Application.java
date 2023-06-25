package faang.school.godbless;

import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Character frodo = new Character("frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " was added to the inventory"));

        // manager.removeItem(frodo, item -> item.getName().equals("The One Ring"));

        manager.updateItem(frodo, item -> item.getName().equals("The One Ring"),
                item -> new Item(item.getName(), item.getValue() * 2));

        System.out.println(frodo.getInventory().toString());
    }
}
