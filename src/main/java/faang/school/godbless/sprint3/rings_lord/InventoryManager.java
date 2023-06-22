package faang.school.godbless.sprint3.rings_lord;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        if (Objects.nonNull(character)) {
            character.getInventory().add(item);
            action.accept(item);
        } else {
            log.warn("Character does not exist");
        }
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        try {
            character.getInventory().removeIf(condition);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> function) {
        try {
            character.getInventory().replaceAll(item -> condition.test(item) ? function.apply(item) : item);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }
}
