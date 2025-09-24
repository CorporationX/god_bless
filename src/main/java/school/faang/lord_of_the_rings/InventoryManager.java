package school.faang.lord_of_the_rings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        consumer.accept(item);
        //        character.getInventory().add(item); ?
    }

    public void removeItem(Character character, Predicate<Item> c) {
        character.getInventory().removeIf(c);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (condition.test(item)) {
                inventory.set(i, updater.apply(item));
            }
        }
    }
}
