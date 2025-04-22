package school.faang.bjs2_70126;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class InventoryManager {
    public void addItem(Item item, Character character, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, UnaryOperator<Item> modifier) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (filter.test(item)) {
                inventory.set(i, modifier.apply(item));
            }
        }
    }
}
