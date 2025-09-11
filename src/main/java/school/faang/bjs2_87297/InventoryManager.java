package school.faang.bjs2_87297;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    void addItem(Character character, Item item, Consumer<Item> callback) {
        if (character == null || item == null) {
            return;
        }
        if (character.getInventory() == null) {
            System.out.println("Inventory cannot be null");
            return;
        }
        character.getInventory().add(item);
        if (callback != null) {
            callback.accept(item);
        }
    }

    void removeItem(Character character, Predicate<Item> condition) {
        if (character == null) {
            throw new IllegalArgumentException("Character cannot be null");
        }
        if (condition == null) {
            throw new IllegalArgumentException("Condition cannot be null");
        }
        if (character.getInventory() == null) {
            throw new IllegalStateException("Character inventory is not initialized");
        }
        Iterator<Item> iterator = character.getInventory().iterator();
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            if (condition.test(currentItem)) {
                iterator.remove();
            }
        }
    }

    void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        if (character != null && condition != null && updater != null) {
            List<Item> inventory = character.getInventory();
            for (int i = 0; i < inventory.size(); i++) {
                Item currentItem = inventory.get(i);
                if (condition.test(currentItem)) {
                    Item updateItem = updater.apply(currentItem);
                    inventory.set(i, updateItem);
                }
            }
        }
    }
}
