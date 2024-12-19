package school.faang.lordoftheringsrpg45704;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character,
                        Item item,
                        Consumer<Item> action) {
        character.addItem(item);
        action.accept(item);
    }

    public void removeItem(Character character,
                           Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character,
                           Predicate<Item> condition,
                           Function<Item, Item> updater) {
        Iterator<Item> iterator = character.getInventory().iterator();

        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (condition.test(item)) {
                iterator.remove();
                character.addItem(updater.apply(item));
            }
        }
    }
}
