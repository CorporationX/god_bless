package school.faang.sprint2.task45673lordofthering;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> addItem) {
        character.addItemToInventory(item);
        character.inventoryCost();
        addItem.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> delItem) {
        character.getInventory().removeIf(delItem);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updateItem) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (condition.test(item)) {
                inventory.set(i, updateItem.apply(item));
            }
        }

    }
}
