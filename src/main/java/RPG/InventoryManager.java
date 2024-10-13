package RPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Item item, Character character, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> modifier) {
        for (int i = 0; i < character.getInventory().size(); i++) {
            Item currentItem = character.getInventory().get(i);
            if (filter.test(currentItem)) {
                Item modifiedItem = modifier.apply(currentItem);
                character.getInventory().set(i, modifiedItem);
            }
        }
    }
}
