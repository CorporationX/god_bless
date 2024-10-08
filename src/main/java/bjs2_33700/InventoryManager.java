package bjs2_33700;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {
    public void addItem(Character character, Consumer<Item> consumer, Item item) {
        consumer.accept(item);
        character.getInventory().add(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> filteredInventory = character.getInventory()
                .stream()
                .filter(item -> !predicate.test(item))
                .collect(Collectors.toList());

        character.setInventory(filteredInventory);
    }

    public void updateItem(
            Character character,
            Predicate<Item> predicate,
            Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            if (predicate.test(inventory.get(i))) {
                Item updatedItem = function.apply(inventory.get(i));
                inventory.set(i, updatedItem);
            }
        }
    }
}
