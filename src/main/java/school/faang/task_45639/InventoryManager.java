package school.faang.task_45639;

import java.util.ListIterator;
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
        ListIterator<Item> inventoryIterator = character.getInventory().listIterator();

        while (inventoryIterator.hasNext()) {
            Item item = inventoryIterator.next();

            if (predicate.test(item)) {
                inventoryIterator.set(function.apply(item));
            }
        }
    }
}
