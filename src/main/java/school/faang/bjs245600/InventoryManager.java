package school.faang.bjs245600;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> func) {
        List<Item> inventory = character.getInventory();

        Stream<Item> matchingItems = inventory.stream()
                .filter(predicate)
                .map(func);

        Stream<Item> nonMatchingItems = inventory.stream()
                .filter(predicate.negate());

        List<Item> updatedInventory = Stream.concat(matchingItems, nonMatchingItems)
                .toList();

        inventory.clear();
        inventory.addAll(updatedInventory);
    }
}