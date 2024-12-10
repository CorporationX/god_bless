package school.faang.lordoftherings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        if (character == null) {
            throw new IllegalArgumentException("Character can't be null");
        }
        if (item == null) {
            throw new IllegalArgumentException("Item can't be null");
        }
        if (action == null) {
            throw new IllegalArgumentException("Action can't be null");
        }
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        if (character == null) {
            throw new IllegalArgumentException("Character can't be null");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Filter can't be null");
        }
        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> transformer) {
        if (character == null) {
            throw new IllegalArgumentException("Character can't be null");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Filter can't be null");
        }
        if (transformer == null) {
            throw new IllegalArgumentException("Transformer can't be null");
        }
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (filter.test(item)) {
                inventory.set(i, transformer.apply(item));
            }
        }
    }
}
