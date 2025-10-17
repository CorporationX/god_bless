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
        character.getInventory()
                .removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> editor) {
        List<Item> inventories = character.getInventory();

        List<Item> updatedInventories = inventories.stream()
                .map(item -> filter.test(item) ? editor.apply(item) : item)
                .toList();

        character.setInventory(updatedInventories);
    }
}
