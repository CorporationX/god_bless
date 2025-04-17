package school.faang.lotr;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> inventory) {
        if (character != null && item != null) {
            character.getInventory().add(item);
            if (inventory != null) {
                inventory.accept(item);
            }
        } else {
            System.out.println("Object null");
        }
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        if (character != null) {
            character.getInventory().removeIf(filter);
        } else {
            System.out.println("Object null");
        }
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updateItem) {
        List<Item> itemList = character.getInventory();
        for (int i = 0; i < itemList.size(); i++) {
            Item newItem = itemList.get(i);
            if (filter.test(newItem)) {
                itemList.set(i, updateItem.apply(newItem));
            }
        }
    }
}
