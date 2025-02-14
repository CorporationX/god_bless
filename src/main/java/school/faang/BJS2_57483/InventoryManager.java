package school.faang.BJS2_57483;

import lombok.NonNull;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(@NonNull Character character,
                        @NonNull Item item,
                        @NonNull Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(@NonNull Character character,
                           @NonNull Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(@NonNull Character character,
                           @NonNull Predicate<Item> filter,
                           @NonNull Function<Item, Item> action) {
        for (Item item : character.getInventory()) {
            if (filter.test(item)) {
                Item newItem = action.apply(item);
                item.setName(newItem.getName());
                item.setValue(newItem.getValue());
            }
        }
    }
}
