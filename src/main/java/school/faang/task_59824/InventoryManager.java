package school.faang.task_59824;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> inventoryItemAdditionAnnouncer) {
        character.getInventory().add(item);
        inventoryItemAdditionAnnouncer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> isItemExist) {
        character.getInventory().removeIf(isItemExist);
    }

    public void updateItem(Character character, Predicate<Item> isItemExist, Function<Item, Item> updateItem) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (isItemExist.test(item)) {
                inventory.set(i, updateItem.apply(item));
            }
        }
    }
}
