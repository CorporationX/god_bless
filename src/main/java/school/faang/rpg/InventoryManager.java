package school.faang.rpg;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> onAdd) {
        character.getInventory().add(item);
        onAdd.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item current = inventory.get(i);
            if (condition.test(current)) {
                inventory.set(i, updater.apply(current));
            }
        }
    }
}