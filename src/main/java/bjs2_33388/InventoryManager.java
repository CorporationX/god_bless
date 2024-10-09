package bjs2_33388;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Consumer<Item> consumer) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                consumer.accept(item);
            }
        }
    }
}
