package school.faang.lor.rpg;

import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> addition) {
        character.getInventory().add(item);
        addition.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        var inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            var item = inventory.get(i);
            if (condition.test(item)) { inventory.remove(item); }
        }
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> update) {
        var inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            var item = inventory.get(i);
            if (condition.test(item)) {
                inventory.set(i, update.apply(item));
            }
        }
    }
}
