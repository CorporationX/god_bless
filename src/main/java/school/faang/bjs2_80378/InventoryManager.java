package school.faang.bjs2_80378;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(List<Item> inventory, Item item, Consumer<Item> action) {
        inventory.add(item);
        action.accept(item);
    }

    public void removeItem(List<Item> inventory, Predicate<Item> filter) {
        Iterator<Item> itemIterator = inventory.iterator();
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            if (filter.test(item)) {
                itemIterator.remove();
            }
        }
    }

    public void updateItem(List<Item> inventory, Predicate<Item> itemToFind, Function<Item, Item> updateItem) {
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (itemToFind.test(item)) {
                Item updated = updateItem.apply(item);
                inventory.set(i, updated);
            }
        }
    }
}
