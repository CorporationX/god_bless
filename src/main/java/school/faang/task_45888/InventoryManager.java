package school.faang.task_45888;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        for (Item item : inventory) {
            if (filter.test(item)) {
                Item updatedItem = function.apply(item);
                item.setName(updatedItem.getName());
                item.setValue(updatedItem.getValue());
            }
        }
    }
}
