package faang.school.godbless.BJS221228;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> items = character.getInventory();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (predicate.test(item)) {
                items.set(i, function.apply(item));
            }
        }
    }

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory AGAIN."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
    }
}