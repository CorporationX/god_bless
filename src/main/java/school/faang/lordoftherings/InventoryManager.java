package school.faang.lordoftherings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        if (character == null || action == null) {
            throw new IllegalArgumentException("Какой-то параметр равен null");
        } else {
            character.getInventory().add(item);
            action.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        if (character == null || filter == null) {
            throw new IllegalArgumentException("Какой-то параметр равен null");
        } else {
            character.getInventory().removeIf(filter);
        }
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> transformer) {
        if (character == null || filter == null || transformer == null) {
            throw new IllegalArgumentException("Какой-то параметр равен null");
        } else {
            List<Item> inventory = character.getInventory();
            for (int i = 0; i < inventory.size(); i++) {
                Item item = inventory.get(i);
                if (filter.test(item)) {
                    inventory.set(i, transformer.apply(item));
                }
            }
        }
    }
}
