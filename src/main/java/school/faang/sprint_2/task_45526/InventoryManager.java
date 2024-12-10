package school.faang.sprint_2.task_45526;

import lombok.NonNull;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public static void addItem(@NonNull Character character, @NonNull Item item, @NonNull Consumer<Item> action) {
        character.getInventory()
                .add(item);
        action.accept(item);
    }

    public static void removeItem(@NonNull Character character, @NonNull Predicate<Item> deleteCondition) {
        character.getInventory()
                .removeIf(deleteCondition);
    }

    public static void updateItem(@NonNull Character character,
                                  @NonNull Predicate<Item> updateCondition,
                                  @NonNull Function<Item, Item> updateFunction) {
        character.getInventory()
                .replaceAll(item ->
                        updateCondition.test(item) ? updateFunction.apply(item) : item);
    }
}
