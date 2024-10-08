package lord_of_the_rings_rpg;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> callback) {
        character.getInventory().add(item);
        callback.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        Item newItem = null;
        for (Item item : character.getInventory()) {
            if (filter.test(item)) {
                newItem = updater.apply(item);
            }
        }
        character.getInventory().removeIf(filter);
        character.getInventory().add(newItem);
    }
}
