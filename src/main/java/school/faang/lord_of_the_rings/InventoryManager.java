package school.faang.lord_of_the_rings;

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
        List<Item> inventory = character.getInventory();
        inventory.removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updateFunction) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (condition.test(item)) {
                inventory.set(i, updateFunction.apply(item));
            }
        }
    }
}