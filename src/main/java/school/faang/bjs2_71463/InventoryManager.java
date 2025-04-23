package school.faang.bjs2_71463;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> onAdd) {
        if (character == null || item == null) {
            log.warn("Персонаж или предмет равен null");
            return;
        }

        List<Item> inventory = character.getInventory();
        boolean exists = inventory.stream()
                .anyMatch(existing -> Objects.equals(existing.id(), item.id()));

        if (exists) {
            log.info("Предмет '{}' уже существует в инвентаре персонажа '{}'", item.name(), character.getName());
            return;
        }

        character.getInventory().add(item);
        onAdd.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        if (character == null) {
            log.warn("Персонаж равен null");
            return;
        }

        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        if (character == null) {
            log.warn("Персонаж равен null");
            return;
        }

        character.getInventory().replaceAll(item -> condition.test(item) ? updater.apply(item) : item);
    }
}
