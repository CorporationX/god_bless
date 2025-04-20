package school.faang.lotr;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> inventory) {
        if (inventory != null && validationData(character, item)) {
            inventory.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);

    }

    public List<Item> updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updateItem) {
        return character.getInventory().stream()
                .filter(filter)
                .map(updateItem)
                .toList();
    }

    private boolean validationData(Character character, Item item) {
        if (character != null && item != null) {
            character.getInventory().add(item);
            return true;
        } else {
            System.out.println("Object null");
            return false;
        }
    }
}
