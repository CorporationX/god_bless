package school.faang.task_45684;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    protected void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    protected void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    protected void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        List<Item> items = character.getInventory();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (condition.test(item)) {
                items.set(i, updater.apply(item));
            }
        }
    }
}
