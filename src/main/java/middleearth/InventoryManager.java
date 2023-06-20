package middleearth;

import middleearth.exception.InventoryLimitIsExceededException;
import middleearth.exception.NoItemException;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> event) {
        if (character.getInventory().size() < character.getMaxInventorySize()) {
            character.getInventory().add(item);
            event.accept(item);
        } else {
            throw new InventoryLimitIsExceededException("An attempt was made to put the item into the filled inventory");
        }
    }

    public void removeItem(Character character, Predicate<Item> checker) {
        for (Item item : character.getInventory()) {
            if (checker.test(item)) {
                character.getInventory().remove(item);
                return;
            }
        }
        throw new NoItemException("The item you are looking for is not in the inventory");
    }

    public void updateItem(Character character, Predicate<Item> checker, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            if (checker.test(inventory.get(i))) {
                inventory.set(i, updater.apply(inventory.get(i)));
                return;
            }
        }
        throw new NoItemException("The item you are looking for is not in the inventory");
    }
}
