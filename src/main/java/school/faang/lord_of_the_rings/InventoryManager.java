package school.faang.lord_of_the_rings;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.addItem(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        List<Item> itemsToRemove = new ArrayList<>();

        for (Item item : character.getInventory()) {
            if (condition.test(item)) {
                itemsToRemove.add(item);
            }
        }

        itemsToRemove.forEach(character::removeItem);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        List<Item> itemsToUpdate = new ArrayList<>();

        for (Item item : character.getInventory()) {
            if (condition.test(item)) {
                itemsToUpdate.add(item);
            }
        }

        for (Item oldItem : itemsToUpdate) {
            Item newItem = updater.apply(oldItem);
            character.updateItem(oldItem, newItem);
        }
    }
}
