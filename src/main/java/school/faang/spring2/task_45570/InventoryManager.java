package school.faang.spring2.task_45570;

import java.util.Iterator;
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
        List<Item> inventory = character.getInventory();
        Iterator<Item> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (predicate.test(item)) {
                iterator.remove();
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate,
                           Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (predicate.test(item)) {
                inventory.set(i, function.apply(item));
            }
        }
    }
}