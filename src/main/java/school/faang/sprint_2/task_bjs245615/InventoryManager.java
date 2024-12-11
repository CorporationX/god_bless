package school.faang.sprint_2.task_bjs245615;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

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
                           @NonNull Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        List<Item> updatedInventory = Stream.concat(
                inventory.stream().filter(filter).map(function),
                inventory.stream().filter(filter.negate())
        ).toList();
        inventory.clear();
        inventory.addAll(updatedInventory);
    }
}
