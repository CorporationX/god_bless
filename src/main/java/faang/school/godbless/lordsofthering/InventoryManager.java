package faang.school.godbless.lordsofthering;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> itemHandler) {
        character.getInventory().add(item);
        itemHandler.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        List<Item> inventory = character.getInventory();
        if (inventory != null) {
            inventory.removeIf(condition);
        }
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> itemUpdater) {
        List<Item> inventory = character.getInventory();
        if (inventory != null) {
            inventory.forEach(item -> {
                if (condition.test(item)) {
                    inventory.set(inventory.indexOf(item), itemUpdater.apply(item));
                }
            });
        }
    }
}
