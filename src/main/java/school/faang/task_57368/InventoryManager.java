package school.faang.task_57368;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character == null || item == null || consumer == null) {
            throw new IllegalArgumentException("Character, item, and consumer must not be null");
        }
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character == null || predicate == null) {
            throw new IllegalArgumentException("Character and predicate must not be null");
        }
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if (character == null || predicate == null || function == null) {
            throw new IllegalArgumentException("Character, predicate, and function must not be null");
        }
        List<Item> updatedInventory = character.getInventory().stream()
                .map(item -> predicate.test(item) ? function.apply(item) : item)
                .collect(Collectors.toList());

        character.setInventory(updatedInventory);
    }
}
