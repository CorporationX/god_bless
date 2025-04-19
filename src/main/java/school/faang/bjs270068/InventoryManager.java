package school.faang.bjs270068;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> activity) {
        character.getInventory().add(item);
        activity.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            Item currentItem = inventory.get(i);
            if (condition.test(currentItem)) {
                Item updatedItem = updater.apply(currentItem);
                inventory.set(i, updatedItem);
            }
        }
    }
}
