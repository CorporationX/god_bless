package school.faang.lordofrings;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> infoToPrint) {
        character.addItem(item);
        infoToPrint.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> conditionToDelete) {
        List<Item> characterItems = character.getInventory();
        characterItems.removeIf(conditionToDelete);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> itemUpdate) {
        List<Item> characterItems = character.getInventory();
        List<Item> updatedItems = new ArrayList<>();
        for (Item item : characterItems) {
            if (condition.test(item)) {
                updatedItems.add(itemUpdate.apply(item));
            } else {
                updatedItems.add(item);
            }
        }
        character.setInventory(updatedItems);
    }
}
