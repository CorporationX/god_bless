package lord_of_the_rings_rpg;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> inventory = new ArrayList<>();

        Character frodo = new Character(inventory);
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        System.out.println(inventory);

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
