package faang.school.godbless.bjs2_21238;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.addItemToInventory(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem1(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        List<Item> updatedOldItems = new ArrayList<>();
        List<Item> updatedNewItems = inventory.stream()
                .filter(predicate)
                .map(item -> {
                    updatedOldItems.add(item);
                    return function.apply(item);
                })
                .toList();

        inventory.removeAll(updatedOldItems);
        inventory.addAll(updatedNewItems);
    }

    public void updateItem2(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> updatedInventory = character.getInventory().stream()
                .map(item -> predicate.test(item)
                        ? function.apply(item)
                        : item)
                .toList();

        character.getInventory().clear();
        character.getInventory().addAll(updatedInventory);
    }
}
