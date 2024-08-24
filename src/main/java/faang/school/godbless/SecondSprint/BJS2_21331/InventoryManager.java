package faang.school.godbless.SecondSprint.BJS2_21331;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character frodo, Predicate<Item> predicate) {
        frodo.getInventory().removeIf(predicate);
    }

    public void updateItem(Character frodo, Predicate<Item> predicate, Function<Item, Item> function) {
        Stream<Item> updatedItem = frodo.getInventory().stream().filter(predicate).map(function);
        Stream<Item> ignoredItem = frodo.getInventory().stream().filter(predicate.negate());
        Stream<Item> result = Stream.concat(updatedItem, ignoredItem);

        frodo.setInventory(result.toList());
    }
}
