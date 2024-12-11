package school.faang.task_45560;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> transformer) {
        for (Item inventoryItem : character.getInventory()) {
            if (filter.test(inventoryItem)) {
                var transformedItem = transformer.apply(inventoryItem);
                inventoryItem.setName(transformedItem.getName());
                inventoryItem.setValue(transformedItem.getValue());
            }
        }
    }
}
