package bjs287272;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Item item, Character character, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> editor) {
        List<Item> inventories = character.getInventory();
        for (int i = 0; i < inventories.size(); i++) {
            Item item = inventories.get(i);
            if (filter.test(item)) {
                inventories.set(i, editor.apply(item));
            }
        }
    }
}
