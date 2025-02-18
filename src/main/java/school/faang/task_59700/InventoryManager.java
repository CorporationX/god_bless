package school.faang.task_59700;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(@NonNull Character character, @NonNull Item item,
                        @NonNull Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(@NonNull Character character, @NonNull Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(@NonNull Character character, @NonNull Predicate<Item> condition,
                           @NonNull Function<Item, Item> update) {
        List<Item> updatedItems = character.getInventory().stream()
                .map(item -> condition.test(item) ? update.apply(item) : item)
                .toList();

        character.setInventory(updatedItems);
    }
}
