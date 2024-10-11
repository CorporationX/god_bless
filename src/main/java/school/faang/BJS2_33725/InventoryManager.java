package school.faang.BJS2_33725;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {
    void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    void addItem(Character character, Item item, BiConsumer<Item, Character> action) {
        character.getInventory().add(item);
        action.accept(item, character);
    }

    void removeItem(Character character, Predicate<Item> removeIfCondition) {
        character.getInventory().removeIf(removeIfCondition);
    }

    void updateItem(Character character, Predicate<Item> finder, Consumer<Item> modifier) {
        character.getInventory().forEach(item -> {
            if (finder.test(item)) {
                modifier.accept(item);
            }
        });
    }
}
