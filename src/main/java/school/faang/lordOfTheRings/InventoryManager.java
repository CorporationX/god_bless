package school.faang.lordOfTheRings;

import java.util.List;
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
        List<Item> newItems = character.getInventory();
        for (int i=0; i<newItems.size(); i++) {
            Item newItem = newItems.get(i);
            if (filter.test(newItem)) {
                newItems.set(i, function.apply(newItem));
            }
        }
    }
}