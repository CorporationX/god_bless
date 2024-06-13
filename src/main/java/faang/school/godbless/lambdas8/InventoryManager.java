package faang.school.godbless.lambdas8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    void addItem(Character character, Item item, Consumer<Item> inventoryItem) {
        character.getInventory().add(item);
        inventoryItem.accept(item);
    }

    void removeItem(Character character, Predicate<Item> condition) {
        Item deleteItem = null;
        for (Item item : character.getInventory()) {
            if (condition.test(item)) {
                deleteItem = item;
            }
        }
        character.getInventory().remove(deleteItem);
    }

    void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> renovation) {
        for (Item item : character.getInventory()) {
            if (condition.test(item)) {
                character.getInventory().remove(item);
                character.getInventory().add(renovation.apply(item));
            }
        }
    }
}
