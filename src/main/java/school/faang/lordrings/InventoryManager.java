package school.faang.lordrings;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, UnaryOperator<Item> action) {
        var inventory = character.getInventory();
        var updateItems = inventory.stream()
                .filter(predicate)
                .map(action)
                .toList();
        inventory.clear();
        inventory.addAll(updateItems);
    }
}
