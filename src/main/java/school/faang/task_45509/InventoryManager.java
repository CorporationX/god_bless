package school.faang.task_45509;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(@NonNull Character character, Item item, Consumer<Item> action) {
        character.addItem(item);
        action.accept(item);
    }

    public void removeItem(@NonNull Character character, Predicate<Item> condition) {
        character.removeItemByCondition(condition);
    }

    public void updateItem(@NonNull Character character, Predicate<Item> itemFilter,
                           Function<Item, Item> itemTransformer) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item currentItem = inventory.get(i);
            if (itemFilter.test(currentItem)) {
                Item updatedItem = itemTransformer.apply(currentItem);
                inventory.set(i, updatedItem);

            }
        }
    }
}
