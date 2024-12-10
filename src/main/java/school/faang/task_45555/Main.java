package school.faang.task_45555;

import school.faang.task_45555.entity.Item;
import school.faang.task_45555.entity.Character;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory"));

        manager.removeItem(frodo, (item) -> Objects.equals(item.getName(), "The One Ring"));

        manager.addItem(frodo, ring,
                (item) -> System.out.println(item.getName() + " was again added to the inventory."));
        manager.updateItem(frodo);

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
