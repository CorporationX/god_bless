package school.faang.Lambda.BJS2_33646;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        Character frodo = new Character("Frodo");
        List<Item> items = Arrays.asList(
                new Item("Sword", 100),
                new Item("Shield", 150),
                new Item("Bow", 120),
                new Item("Stone", 0),
                new Item("Elven Cloak", 200),
                new Item("Stick", 0)
        );

        Consumer<Item> addItemConsumer = item -> System.out.println(item.getName() + " был добавлен в инвентарь.");
        items.forEach(item -> inventoryManager.addItem(frodo, item, addItemConsumer));

        Predicate<Item> zeroValuePredicate = item -> item.getValue() == 0;
        Predicate<Item> bowPredicate = item -> "Bow".equals(item.getName());
        inventoryManager.removeItem(frodo, zeroValuePredicate.or(bowPredicate));

        inventoryManager.updateItem(frodo,
                item -> "Shield".equals(item.getName()),
                item -> item.setValue(item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
