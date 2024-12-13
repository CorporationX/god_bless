package school.faang.task_45583;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character == null || item == null || consumer == null) {
            throw new IllegalArgumentException("Character, item, and consumer must not be null");
        }
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character == null || predicate == null) {
            throw new IllegalArgumentException("Character and predicate must not be null");
        }
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updater) {
        if (character == null || predicate == null || updater == null) {
            throw new IllegalArgumentException("Character, predicate, and updater must not be null");
        }
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (predicate.test(item)) {
                inventory.set(i, updater.apply(item));
            }
        }
    }
}