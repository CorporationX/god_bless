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
        checkNotNull(character, "Character cannot be null");
        checkNotNull(item, "Item cannot be null");
        character.getInventory().add(item);
        message.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        checkNotNull(character, "Character cannot be null");
        if (!character.getInventory().removeIf(filter)) {
            String errorMessage = "Item not found";
            log.error(errorMessage);
            throw new NoSuchElementException(errorMessage);
        }
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> function) {
        checkNotNull(character, "Character cannot be null");
        List<Item> inventory = character.getInventory();
        Item item = inventory.stream()
                .filter(filter)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Item not found"));
        inventory.set(inventory.indexOf(item), function.apply(item));
    }

    private void checkNotNull(Object object, String message) {
        if (object == null) {
            log.error(message);
            throw new IllegalArgumentException(message);
        }
    }
}