package school.faang.lord_of_rings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> actionMaker) {
        character.getInventory().add(item);
        actionMaker.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemFilter) {
        boolean wasItemRemoved = character.getInventory().removeIf(itemFilter);
        if (wasItemRemoved) {
            System.out.println("Inventory was updated, removal completed as per the filter");
        }
    }

    public void updateItem(Character character, Function<Item, Item> transformer) {
        character.getInventory().forEach(transformer::apply);
    }
}
