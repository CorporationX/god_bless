package school.faang.bjs45643;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        if (action != null) {
            action.accept(item);
        }
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> action) {
        List<Item> inventory = new ArrayList<>(character.getInventory());
        character.getInventory().forEach(item -> {
            if (condition.test(item)) {
                inventory.add(action.apply(item));
                inventory.remove(item);
            }
        });
        character.setInventory(inventory);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }
}
