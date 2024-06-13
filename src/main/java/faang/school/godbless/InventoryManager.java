package faang.school.godbless;

import lombok.NonNull;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    @NonNull
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    @NonNull
    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    @NonNull
    public void updateItem(Character character, Predicate<Item> predicate,
                           Function<Item, Item> function) {
        character.getInventory().stream()
                .filter(predicate)
                .forEach(item -> function.apply(item));
    }
}
