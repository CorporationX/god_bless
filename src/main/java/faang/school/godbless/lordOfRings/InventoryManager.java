package faang.school.godbless.lordOfRings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> performer) {
        character.setInventory(item);
        performer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> conditionToRemove) {
        List<Item> items = character.getInventory();
        items.removeIf(conditionToRemove);
    }

    public void updateItem(Character character, Predicate<Item> conditionToUpdate, Function<Item, Item> updater) {
        List<Item> items = character.getInventory();
        for (int i=0; i<items.size(); i++) {
            if (conditionToUpdate.test(items.get(i))) {
                Item updatedItem = updater.apply(items.get(i));
                items.set(i, updatedItem);
                break;
            }
        }
    }
}
