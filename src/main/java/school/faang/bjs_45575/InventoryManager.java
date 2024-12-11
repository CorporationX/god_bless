package school.faang.bjs_45575;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        if (character == null || item == null || action == null) {
            throw new IllegalArgumentException("Invalid character or Item or Action");
        }

        character.addItem(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        if (character == null || filter == null) {
            throw new IllegalArgumentException("Invalid character or Item or Predicate");
        }

        List<Item> items = character.getInventory().stream()
                .filter(filter)
                .toList();
        items.forEach(character::removeItem);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> action) {
        if (character == null || filter == null || action == null) {
            throw new IllegalArgumentException("Invalid Character or Filter or Action");
        }

        character.getInventory().stream()
                .filter(filter)
                .forEach(item -> character.updateItem(action.apply(item)));
    }

}
