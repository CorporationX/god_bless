package school.faang.sprint2.task_5;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        if (character == null) {
            throw new IllegalArgumentException("Character cannot be null");
        }
        action.accept(item);
        character.getInventory().add(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character == null) {
            throw new IllegalArgumentException("Character cannot be null");
        }
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updater) {
        if (character == null) {
            throw new IllegalArgumentException("Character cannot be null");
        }
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            if (predicate.test(inventory.get(i))) {
                inventory.set(i, updater.apply(inventory.get(i)));
            }
        }
    }
}
