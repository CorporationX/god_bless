package school.faang.bjs2_87302;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
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

    public void removeItem(Character character, Predicate<Item> filter) {

        if (character == null) {
            throw new IllegalArgumentException("Персонаж не может быть null");
        }

        if (character.getInventory().isEmpty()) {
            log.info("Инвентарь персонажа {} пуст", character.getName());
            return;
        }


        boolean removedAny = character.getInventory().removeIf(filter);
        if (removedAny) {
            log.info("Предметы удалены по фильтру");
        }
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> transformer) {
        List<Item> inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (filter.test(item)) {
                Item updatedItem = transformer.apply(item);
                inventory.set(i, updatedItem);
                log.info("Предмет {} обновлён", item.getName());
            }
        }
    }
}
