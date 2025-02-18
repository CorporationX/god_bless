package school.faang.task_57586;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(@NonNull Character character, @NonNull Item item, @NonNull Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(@NonNull Character character, @NonNull Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(@NonNull Character character,
                           @NonNull Predicate<Item> filter,
                           @NonNull Consumer<Item> updater) {
        List<Item> inventory = character.getInventory();
        if (inventory != null) {
            inventory.stream()
                    .filter(filter)
                    .forEach(updater);
        }
    }
}
