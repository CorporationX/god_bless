package task_BJS2_57435;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(@NonNull Character character, Item item, Consumer<Item> itemAction) {
        List<Item> inventory = character.getInventory();
        inventory.add(item);
        itemAction.accept(item);
    }

    public void removeItem(@NonNull Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(@NonNull Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (predicate.test(item)) {
                inventory.set(i, function.apply(item));
            }
        }
    }
}
