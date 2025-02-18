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
        List<Item> items = character.getInventory();

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (condition.test(item)) {
                items.set(i, update.apply(item));
            }
        }
    }
}
