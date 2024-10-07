package school.faang.lordOfTheRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> handler) {
        character.getInventory().add(item);
        handler.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (filter.test(item)) {
                Item newItem = function.apply(item);
                item.setName(newItem.getName());
                item.setValue(newItem.getValue());
            }
        }
    }
}
