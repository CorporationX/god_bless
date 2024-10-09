package school.faang.lord_of_the_rings_BJS2_33643;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character(new ArrayList<>());
        Item ring = new Item("The One Ring", 1000);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
