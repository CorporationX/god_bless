package school.faang.lordrings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> handler) {
        character.addItem(item);
        handler.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        character.getInventory().replaceAll(item -> {
            if (condition.test(item)) {
                return updater.apply(item);
            } else {
                return item;
            }
        });
    }
}
