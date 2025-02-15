package school.faang.lord;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public static void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public static void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updater) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                Item updatedItem = updater.apply(item);
                item.setValue(updatedItem.getValue());
            }
        }
    }
}
