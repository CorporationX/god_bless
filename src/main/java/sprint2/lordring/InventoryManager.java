package sprint2.lordring;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character name, Item item, Consumer<Item> consumer) {
        name.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character name, Predicate<Item> filter) {
        name.getInventory().removeIf(filter);
    }

    public void updateItem(Character name, Predicate<Item> filter, Function<Item, Item> updateValue) {
        for (int i = 0; i < name.getInventory().size(); i++) {
            Item item = name.getInventory().get(i);
            if (filter.test(item)) {
                name.getInventory().set(i, updateValue.apply(item));
            }
        }
    }
}
