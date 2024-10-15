package lordOfTheRingsRpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.addItem(item);
        action.accept(item);
    }

    public void removeItem(Character character,Predicate<Item> filter) {
        if(character.getInventory().stream().anyMatch(filter)) {
            character.getInventory().removeIf(filter);
        }
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> action) {
        character.getInventory().stream()
                .filter(filter)
                .map(action);
    }
}
