package faang.school.godbless.lordRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> updatedItem) {
        character.getInventory().add(item);
        updatedItem.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> desiredItem) {
        character.getInventory().removeIf(desiredItem);
    }

    public void updateItem(Character character, Predicate<Item> precondition, Function<Item, Item> resultItem) {
        character.getInventory().stream()
                .filter(precondition)
                .findFirst()
                .ifPresent(item -> {
                    Item updatedItem = resultItem.apply(item);
                    int index = character.getInventory().indexOf(item);
                    character.getInventory().set(index, updatedItem);
                });
        }

}
