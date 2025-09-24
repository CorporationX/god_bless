package school.faang.lord_of_the_rings;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @SuppressWarnings("checkstyle:LineLength")
    public static void main(String[] args) {
        List<Item> inventory = new ArrayList<>();


        Character frodo = new Character("Frodo", inventory);

        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item -> {
            inventory.add(item);
            System.out.println(item.getName() + " Был добавлен в инвентарь.");
        }));
        System.out.println(frodo.getInventory());

        manager.removeItem(frodo, item -> item.getName().contains("The One Ring"));

        System.out.println(frodo.getInventory());

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
