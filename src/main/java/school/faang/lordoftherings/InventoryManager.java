package school.faang.lordoftherings;

import lombok.extern.slf4j.Slf4j;

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
        for (int i = 0; i < character.getInventory().size(); i++) {
            if (predicate.test(character.getInventory().get(i))) {
                character.getInventory().remove(character.getInventory().get(i));
                log.info("Предмет успешно удалён из инвентаря игрока");
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        checkArguments(character, predicate);
        validArgument(function);
        for (int i = 0; i < character.getInventory().size(); i++) {
            Item item = character.getInventory().get(i);
            if (predicate.test(item)) {
                Item updateItem = function.apply(item);
                character.getInventory().add(updateItem);
                character.getInventory().remove(item);
            }
        }
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