package school.faang.sprint2.task_5;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(@NonNull Character character,
                        @NonNull Item item,
                        @NonNull Consumer<Item> action) {

        action.accept(item);
        character.getInventory().add(item);
    }

    public void removeItem(@NonNull Character character,
                           @NonNull Predicate<Item> predicate) {

        character.getInventory().removeIf(predicate);
    }

    public void updateItem(@NonNull Character character,
                           @NonNull Predicate<Item> predicate,
                           @NonNull Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            if (predicate.test(inventory.get(i))) {
                inventory.set(i, updater.apply(inventory.get(i)));
            }
        }
    }
}
