package lord.of.the.rings;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {

    public void addItem(Character character, Item item) {
        if (Objects.isNull(character) || Objects.isNull(item)) {
            throw new IllegalArgumentException("One of the arguments is null!");
        }
        character.getInventory().add(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (Objects.isNull(character) || Objects.isNull(predicate)) {
            throw new IllegalArgumentException("One of the arguments is null!");
        }
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character,
                           Predicate<Item> predicate,
                           Consumer<Item> consumer) {
        if (Objects.isNull(character) || Objects.isNull(predicate) || Objects.isNull(consumer)) {
            throw new IllegalArgumentException("One of the arguments is null!");
        }
        character.getInventory().stream().filter(predicate).forEach(consumer);
    }
}
