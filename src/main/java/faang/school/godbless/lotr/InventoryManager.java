package faang.school.godbless.lotr;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    private static final int INVENTORY_SIZE = 30;

    public void addItem(Character character, Item item, Consumer<Item> onSuccess) {
        if (character.getInventory().size() >= INVENTORY_SIZE) {
            throw new IllegalStateException("Inventory is full");
        } else {
            character.addItem(item);
            onSuccess.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        if (character.getInventory().size() < 1) {
            throw new IllegalStateException("Inventory is empty");
        } else {
            character.removeItemIf(condition);
        }
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> update) {
        if (character.getInventory().size() < 1) {
            throw new IllegalStateException("Inventory is empty");
        } else {
            character.updateItemIf(condition, update);
        }
    }
}
