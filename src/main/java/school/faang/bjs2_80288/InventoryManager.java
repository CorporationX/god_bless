package school.faang.bjs2_80288;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character hero, Item item, Consumer<Item> action) {
        hero.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character hero, Predicate<Item> filter) {
        hero.getInventory().removeIf(filter);
    }

    public void updateItem(Character hero, Predicate<Item> filter, Function<Item, Item> action) {
        List<Item> inventory = hero.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (filter.test(item)) {
                inventory.set(i, action.apply(item));
            }
        }
    }
}
