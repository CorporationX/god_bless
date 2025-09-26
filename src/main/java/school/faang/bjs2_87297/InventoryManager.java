package school.faang.bjs2_87297;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> callback) {
        if (character == null) {
            log.error("Attempt to add item to null character");
            throw new IllegalArgumentException("Character cannot be null");
        }
        if (item == null) {
            log.error("Attempt to add null item to character: {}", character.getName());
            return;
        }
        if (character.getInventory() == null) {
            log.error("Inventory is null for character: {}", character.getName());
            throw new IllegalStateException("Inventory is not initialized for character: " + character.getName());
        }
        character.getInventory().add(item);
        if (callback != null) {
            callback.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        if (character == null) {
            log.error("Attempt to remove item to null character");
            throw new IllegalArgumentException("Character cannot be null");
        }
        if (condition == null) {
            log.error("Attempt to pass a null predicate");
            throw new IllegalArgumentException("Condition cannot be null");
        }
        if (character.getInventory() == null) {
            log.error("Inventory is null for character: {}", character.getName());
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

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
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
