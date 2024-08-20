package faang.school.godbless.lordOfTheRings;

import lombok.NonNull;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(@NonNull Character character,
                        @NonNull Item item,
                        @NonNull Consumer<String> consumer) {
        if (character.getInventory().contains(item)) {
            System.out.println(item.getName() + " already in inventory");
        } else {
            character.getInventory().add(item);
            consumer.accept(item.getName());
        }
    }

    public void removeItem(@NonNull Character character,
                           @NonNull Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(@NonNull Character character,
                           @NonNull Predicate<Item> filter,
                           @NonNull Function<Item, Item> handler) {
        Optional<Item> itemInInventory = character.getInventory().stream().filter(filter).findFirst();
        itemInInventory.ifPresent(handler::apply);
    }
}
