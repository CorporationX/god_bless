package school.faang.lordofrings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public static void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public static void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        Item newItem = null;
        Integer indexOfItem = null;
        for (Item item : character.getInventory()) {
            if (filter.test(item)) {
                newItem = updater.apply(item);
                indexOfItem = character.getInventory().indexOf(item);
                character.getInventory().set(indexOfItem, newItem);
            }
        }
    }
}