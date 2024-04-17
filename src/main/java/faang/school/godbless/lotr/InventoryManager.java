package faang.school.godbless.lotr;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        List<Item> inventory = character.getInventory();
        inventory.add(item);
        character.setInventory(inventory);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> inventory = character.getInventory();
        inventory.removeIf(predicate);
        character.setInventory(inventory);
    }
    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        for (Item item : inventory) {
            if (predicate.test(item)) {
                int indexOfItem = inventory.indexOf(item);
                Item updatedItem = function.apply(item);
                inventory.set(indexOfItem, updatedItem);
                character.setInventory(inventory);
                break;
            }
        }
    }
}
