package school.faang.sprint_2.task_bjs245615;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class InventoryManager {
    public void addItem(@NonNull Character character, @NonNull Item item, @NonNull Consumer<Item> action) {
        List<Item> items = character.getInventory();
        items.add(item);
        action.accept(item);
    }

    public void removeItem(@NonNull Character character, @NonNull Predicate<Item> filter) {
        List<Item> inventory = character.getInventory();
        inventory.removeIf(filter);
    }

    public void updateItem(@NonNull Character character,
                           @NonNull Predicate<Item> filter,
                           @NonNull UnaryOperator<Item> function) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (filter.test(item)) {
                inventory.set(i, function.apply(item));
            }
        }
    }
}
