package school.faang.bratva_and_ring;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Item item, Character character, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void update(Character character, Predicate<Item> filter, Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (filter.test(item)) {
                Item newItem = function.apply(item);
                character.getInventory().remove(item);
                character.getInventory().add(newItem);
                return;
            }
        }
    }
}
