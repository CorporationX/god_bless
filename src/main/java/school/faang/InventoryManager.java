package school.faang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        Iterator<Item> iterator = character.getInventory().iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (predicate.test(item)) {
                iterator.remove();
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate,
                           Function<Item, Item> function) {
        ListIterator<Item> iterator = character.getInventory().listIterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (predicate.test(item)) {
                Item updatedItem = function.apply(item);
                iterator.set(updatedItem);
            }
        }
    }
}
