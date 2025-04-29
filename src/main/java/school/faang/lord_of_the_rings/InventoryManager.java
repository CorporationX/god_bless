package school.faang.lord_of_the_rings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Item item, Character character, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> update) {
        List<Item> inventory = character.getInventory();

        for (Item item : inventory) {
            if (condition.test(item)) {
                Item newItem = update.apply(item);
                inventory.set(inventory.indexOf(item), newItem);
            }
        }
    }
}
