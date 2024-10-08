package school.faang.lordoftherings;

import lombok.NoArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@NoArgsConstructor
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> inventoryUpdater) {
        character.addItem(item);
        inventoryUpdater.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> removeItemFilter) {
        character.getInventory().removeIf(removeItemFilter);
    }

    public void updateItem(Character character, Predicate<Item> itemToBeUpdated, Function<Item, Item> changeToApply) {
        character.getInventory().forEach(item -> {
            if (itemToBeUpdated.test(item)) {
                character.updateItem(item, changeToApply.apply(item));
            }
        });
    }
}
