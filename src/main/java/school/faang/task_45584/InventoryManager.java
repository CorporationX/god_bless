package school.faang.task_45584;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


@Slf4j
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> message) {
        checkNotNull(character);
        checkNotNull(item);
        character.getInventory().add(item);
        message.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        checkNotNull(character);
        boolean removed = !character.getInventory().removeIf(filter);

        if (removed) {
            String errorMessage = "Item not found";
            log.error(errorMessage);
            throw new NoSuchElementException(errorMessage);
        }
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> function) {
        checkNotNull(character);
        List<Item> inventory = character.getInventory();

        List<Item> updatedInventory = inventory.stream()
                .map(item -> filter.test(item) ? function.apply(item) : item)
                .toList();

        inventory.clear();
        inventory.addAll(updatedInventory);
    }

    private void checkNotNull(Object object) {
        if (object == null) {
            String message = "Object cannot be null";
            log.error(message);
            throw new IllegalArgumentException(message);
        }
    }
}