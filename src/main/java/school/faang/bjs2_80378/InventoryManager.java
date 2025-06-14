package school.faang.bjs2_80378;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(List<Item> inventory, Item itemToAdd, Consumer<Item> itemToAddAction) {
        inventory.add(itemToAdd);
        itemToAddAction.accept(itemToAdd);
    }

    public void removeItem(List<Item> inventory, Predicate<Item> itemToRemoveAction) {
        Iterator<Item> itemIterator = inventory.iterator();
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            if (itemToRemoveAction.test(item)) {
                itemIterator.remove();
            }
        }
    }

    public void updateItem(List<Item> inventory, Predicate<Item> itemToFind, Function<Item, Item> updateItem) {
        for (Item item : inventory) {
            if (itemToFind.test(item)) {
                updateItem.apply(item);
            }
        }
    }
}
