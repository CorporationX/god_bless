package school.faang.lordoftherings;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        checkArguments(character, item);
        validArgument(consumer);
        consumer.accept(item);
        character.getInventory().add(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        checkArguments(character, predicate);
        int sizeOriginal = character.getInventory().size();
        character.getInventory().removeIf(predicate);
        if (sizeOriginal > character.getInventory().size()) {
            log.info("Предмет успешно удалён из инвентаря игрока");
        } else {
            log.info("Предмет не найден в инвентаре");
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        checkArguments(character, predicate);
        validArgument(function);
        List<Item> inventory = character.getInventory();
        List<Item> updateInventory =
                inventory.stream()
                        .map(item -> {
                            if (predicate.test(item)) {
                                log.info("Предмет {} обновлён", item.name());
                                return function.apply(item);
                            } else {
                                return item;
                            }
                        })
                        .toList();
        inventory.clear();
        inventory.addAll(updateInventory);
    }

    private void checkArguments(Object objectFirst, Object objectSecond) {
        if (objectFirst == null || objectSecond == null) {
            throw new IllegalArgumentException("ошибка: переменная равна null");
        }
    }

    private void validArgument(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("ошибка: переменная равна null");
        }
    }
}