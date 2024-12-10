package school.faang.sprint_2.task_45521;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class InventoryManager {
    @NonNull
    private final Character character;

    public void addItem(@NonNull Item item, @NonNull Consumer<Item> action) {
        character.getItems().add(item);
        action.accept(item);
    }

    public boolean removeItem(@NonNull Predicate<Item> itemFilter) {
        return character.getItems().removeIf(itemFilter);
    }

    public void updateItem(@NonNull Predicate<Item> itemFilter, @NonNull Function<Item, Item> itemUpdate) {
        character.getItems().replaceAll(item -> {
            if (itemFilter.test(item)) {
                return itemUpdate.apply(item);
            }
            return item;
        });
    }
}
