package lotr;

import lombok.NonNull;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(@NonNull Character character, @NonNull Item item, @NonNull Consumer<Item> consumer) {
        if (character.getInventory().contains(item)) {
            System.out.printf("\nThis item already in %s's inventory\n", character.getName());
        } else {
            character.getInventory().add(item);
            consumer.accept(item);
        }
    }

    public void removeItem(@NonNull Character character, @NonNull Predicate<Item> predicate) {
        if(!character.getInventory().removeIf(predicate)) {
            System.out.println("\nThere is no such items in inventory");
        }
    }

    public void updateItem(@NonNull Character character,
                           @NonNull Predicate<Item> predicate,
                           @NonNull Function<Item, Item> function) {
        var inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            if (predicate.test(inventory.get(i))) {
                inventory.set(i, function.apply(inventory.get(i)));
            }
        }
    }
}
