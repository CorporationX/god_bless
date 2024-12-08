package school.faang.task_45509;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        if (character == null) {
            throw new IllegalArgumentException("Character s absent");
        }
        if (character.getInventory() == null) {
            character.setInventory(new ArrayList<>());
        }
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        if (character == null) {
            throw new IllegalArgumentException("Character s absent");
        }
        if (character.getInventory() == null) {
            throw new IllegalArgumentException("Inventory for " + character.getName() + " is absent");
        }
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> map) {
        if (character == null) {
            throw new IllegalArgumentException("Character s absent");
        }
        if (character.getInventory() == null) {
            throw new IllegalArgumentException("Inventory for " + character.getName() + " is absent");
        }
        for (Item item : character.getInventory()) {
            if (filter.test(item)) {
                item.setValue(map.apply(item).getValue());
            }
        }
    }
}
