package school.faang.sprint_2.task_45593;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        for (Item item : character.getInventory()) {
            if (filter.test(item)) {
                item = updater.apply(item);
            }
        }
    }
}
