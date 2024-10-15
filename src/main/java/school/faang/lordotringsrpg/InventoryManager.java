package school.faang.lordotringsrpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    // Method to add an item to the character's inventory
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item); // Perform additional action, e.g., print message
    }

    // Method to remove items from the inventory based on a condition
    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition); // Remove items that match the condition
    }

    // Method to update items in the inventory based on a condition
    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        for (int i = 0; i < character.getInventory().size(); i++) {
            Item item = character.getInventory().get(i);
            if (condition.test(item)) { // If the item matches the condition
                character.getInventory().set(i, updater.apply(item)); // Update the item
            }
        }
    }
}

