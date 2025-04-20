package school.faang.lotr;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {


    public void addItem(Character character, Item item, Consumer<Item> actionAfterItemAddedToInventory) {
        if (actionAfterItemAddedToInventory != null && isCorrectData(character, item)) {
            character.getInventory().add(item);
            actionAfterItemAddedToInventory.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);

    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updateItem) {
        character.getInventory().replaceAll(item -> filter.test(item) ? updateItem.apply(item) : item);
    }

    private boolean isCorrectData(Character character, Item item) {
        if (character != null && item != null) {
            return true;
        } else {
            log.error("Объект не может быть null");
            return false;
        }
    }
}
