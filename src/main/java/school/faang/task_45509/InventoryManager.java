package school.faang.task_45509;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        if (character == null) {
            throw new IllegalArgumentException("Character s absent");
        }
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        if (character == null) {
            throw new IllegalArgumentException("Character is absent");
        }
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> itemFilter, Function<Item, Item> itemTransformer) {
        if (character == null) {
            throw new IllegalArgumentException("Character s absent");
        }
        List<Item> inventory = character.getInventory();
        for (Item currentItem : inventory) {
            if (itemFilter.test(currentItem)) {
                Item newItem = itemTransformer.apply(currentItem);
                updateItem(currentItem, inventory, newItem);
            }
        }
    }

    private void updateItem(Item currentItem, List<Item> inventory, Item newItem) {
        inventory.remove(currentItem);
        inventory.add(newItem);
    }
}
