package school.faang.task_59650;

import lombok.NonNull;

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
                           @NonNull Function<Item, Item> updateFunction) {
        character.getInventory()
                .replaceAll(item ->
                        condition.test(item) ? updateFunction.apply(item) : item);
    }
}



