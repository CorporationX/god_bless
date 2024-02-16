package faang.school.godbless.lordOfRings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> performer) {
        List<Item> items = character.getInventory();
        if (!items.contains(item)) {
            character.setInventory(item);
            performer.accept(item);
        }
        else {
            System.out.println("Item" + item.name + " already exist.");
        }
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        List<Item> items = character.getInventory();
        items.removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        List<Item> items = character.getInventory();
        for (Item item: items) {
            if (filter.test(item)) {
                Item updatedItem = updater.apply(item);
                int index = character.getInventory().indexOf(item);
                items.set(index, updatedItem);
                break;
            }
        }

    }
}
