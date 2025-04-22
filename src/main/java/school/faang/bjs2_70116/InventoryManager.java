package school.faang.bjs2_70116;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> action) {
        character.getInventory().removeIf(action);
    }

    public void updateItem(Character character, Predicate<Item> action, Function<Item, Item> alterItem) {
        List<Item> alteredItems = character.getInventory().stream().filter(action).map(alterItem).toList();
        character.setInventory(alteredItems);
    }
}
