package faang.school.godbless.lambda;

import lombok.NonNull;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(@NonNull Character character, @NonNull Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(@NonNull Character character, Predicate<Item> itemFilter) {
        character.getInventory().removeIf(itemFilter);
    }

    public void updateItem(Character character, Predicate<Item> itemFilter, Function<Item, Item> itemFunction) {
        character.getInventory().stream()
                .filter(itemFilter)
                .toList()
                .forEach(item -> {
                    character.getInventory().remove(item);
                    character.getInventory().add(itemFunction.apply(item));
                });
    }
}
