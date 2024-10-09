package school.faang.lotrrpg;

import lombok.experimental.UtilityClass;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

@UtilityClass
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        Objects.requireNonNull(character, "character cannot be null");
        Objects.requireNonNull(item, "item cannot be null");
        action =  Objects.requireNonNullElse(action, i -> {});

        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        Objects.requireNonNull(character, "character cannot be null");
        Objects.requireNonNull(filter, "filter cannot be null");

        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Consumer<Item> action) {
        Objects.requireNonNull(character, "character cannot be null");
        Objects.requireNonNull(filter, "filter cannot be null");
        Objects.requireNonNull(action, "action cannot be null");

        character.getInventory().forEach(item -> {
            if (filter.test(item)) {
                action.accept(item);
            }
        });
    }
}
