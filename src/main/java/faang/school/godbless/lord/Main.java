package faang.school.godbless.lord;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {
        List<Item> items = new ArrayList<>();
        Character fedor = new Character(items);
        Item ring = new Item("ring", 500);
        InventoryManager manager = new InventoryManager();
        manager.addItem(fedor, ring, (it) -> System.out.println(it.getName() + " was added to the inventory."));
        manager.updateItem(fedor, (item) -> item.getName().equals("ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        System.out.println(fedor.getInventory());
        manager.removeItem(fedor, (item) -> item.getName().equals("ring"));
        System.out.println(fedor.getInventory());
    }
}
