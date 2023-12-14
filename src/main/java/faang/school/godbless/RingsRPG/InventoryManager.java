package faang.school.godbless.RingsRPG;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item ring2 = new Item("The One Ring2", 1000);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        System.out.println(frodo.getInventory());
        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        manager.addItem(frodo, ring2, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        System.out.println(frodo.getInventory());
        // Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring2"), (item) -> new Item(item.getName(), item.getValue() * 2));
        System.out.println(frodo.getInventory());
    }
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            if (predicate.test(inventory.get(i))) {
                inventory.remove(i);
            }
        }
    }
    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item inventaryItem = inventory.get(i);
            if (predicate.test(inventaryItem)) {
                function.apply(inventaryItem);
            }
        }
    }
}
