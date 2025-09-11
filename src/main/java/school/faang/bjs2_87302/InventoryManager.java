package school.faang.bjs2_87302;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {

        if (item == null) {
            throw new IllegalArgumentException("Нельзя добавить пустоту");
        }

        if (character.getInventory() == null) {
            throw new IllegalArgumentException("Инвентарь не инициализирован");
        }

        character.getInventory().add(item);
        action.accept(item);
        log.info("Добавлен предмет {} персонажу {}, стоимостью {}",
                item.getName(), character.getName(), item.getValue());
    }

    public boolean removeItem(Character character, Predicate<Item> filter) {

        if (character == null) {
            throw new IllegalArgumentException("Персонаж не может быть null");
        }

        if (character.getInventory().isEmpty()) {
            log.info("Инвентарь персонажа {} пуст", character.getName());
            return false;
        }


        boolean removedAny = character.getInventory().removeIf(filter);
        if (removedAny) {
            log.info("Предметы удалены по фильтру");
        }
        return removedAny;
    }

    public boolean updateItem(Character character, Predicate<Item> filter, Function<Item, Item> transformer) {

        Item foundItem = null;
        for (Item item : character.getInventory()) {
            if (filter.test(item)) {
                foundItem = item;
                break;
            }
        }

        if (foundItem != null) {
            Item transformerItem = transformer.apply(foundItem);

            character.getInventory().remove(foundItem);
            character.getInventory().add(transformerItem);

            log.info("Предмет {} обновлён", foundItem.getName());
            return true;
        }
        log.info("Предмет не найден по фильтру");
        return false;
    }
}
