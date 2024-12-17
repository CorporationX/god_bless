package school.faang.lordoftheringsrpg45704;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.addItem(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition,
                           Function<Item, Item> updater) {
        for (int i = 0; i < character.getInventory().size(); i++) {
            Item item = character.getInventory().get(i);
            if (condition.test(item)) {
                character.removeItem(item);
                character.addItem(updater.apply(item));
            }
        }
    }
}