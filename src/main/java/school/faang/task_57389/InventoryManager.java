package school.faang.task_57389;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        checkCharacter(character);
        checkItem(item);
        checkConsumer(consumer);
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        checkCharacter(character);
        checkPredicate(predicate);
        List<Item> inventory = character.getInventory();
        List<Item> removedItems = new ArrayList<>();
        inventory.removeIf(item -> {
            if (predicate.test(item)) {
                removedItems.add(item);
                return true;
            }
            return false;
        });
        if (!removedItems.isEmpty()) {
            log.info("Удалены предметы из инвентаря: {}", removedItems);
        } else {
            log.info("Нет предметов, соответствующих критериям удаления.");
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Consumer<Item> consumer) {
        checkCharacter(character);
        checkPredicate(predicate);
        checkConsumer(consumer);
        character.getInventory().stream().filter(predicate).forEach(consumer);
    }

    private void checkCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Персонаж отсутствует");
        }
    }

    private void checkItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Предмет отсутствует");
        }
    }

    private void checkConsumer(Consumer<Item> consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("Поле consumer пустое");
        }
    }

    private void checkPredicate(Predicate<Item> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("Поле predicate пустое");
        }
    }
}
