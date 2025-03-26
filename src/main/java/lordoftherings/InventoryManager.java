package lordoftherings;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        Objects.requireNonNull(character, "Character cannot be null");
        Objects.requireNonNull(item, "Item cannot be null");
        Objects.requireNonNull(consumer, "Consumer cannot be null");

        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        Objects.requireNonNull(character, "Character cannot be null");
        Objects.requireNonNull(predicate, "Predicate cannot be null");

        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        Objects.requireNonNull(character, "Character cannot be null");
        Objects.requireNonNull(predicate, "Predicate cannot be null");
        Objects.requireNonNull(function, "Function cannot be null");

        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (predicate.test(item)) {
                inventory.set(i, function.apply(item));
            }
        }
    }
}
