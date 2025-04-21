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
        List<Item> itemsToRemove = character.getInventory().stream().filter(action).toList();
        character.getInventory().removeAll(itemsToRemove);
    }

    public void updateItem(Character character, Predicate<Item> action, Function<Item, Item> alterItem) {
        character.setInventory(character.getInventory().stream().filter(action).map(alterItem).toList());
    }
}
