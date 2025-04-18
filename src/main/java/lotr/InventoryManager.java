package lotr;

import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        ListIterator<Item> itemIterator = character.getInventory().listIterator();
        while (itemIterator.hasNext()) {
            Item currentItem = itemIterator.next();
            if (filter.test(currentItem)) {
                itemIterator.set(currentItem);
            }
        }
    }
}

