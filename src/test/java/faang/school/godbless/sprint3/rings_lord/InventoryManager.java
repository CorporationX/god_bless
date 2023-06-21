package faang.school.godbless.sprint3.rings_lord;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        if (character != null) {
            character.getInventory().add(item);
            action.accept(item);
        } else {
            log.warn("Character is not exist");
        }
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        try {
            character.getInventory().remove(
                    character.getInventory().stream()
                    .filter(condition)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("This item is not in inventory"))
            );
        } catch (RuntimeException e) {
            log.warn(e.getMessage());
        }
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> function) {
        try {
            Item newItem = function.apply(character.getInventory().stream()
                            .filter(condition)
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("This item is not in inventory")));
            for (Item item : character.getInventory()) {
                if (condition.test(item)) {
                    character.getInventory().remove(item);
                    break;
                }
            }
            character.getInventory().add(newItem);
        } catch (RuntimeException e) {
            log.warn(e.getMessage());
        }
    }
}
