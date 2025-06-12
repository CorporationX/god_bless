package school.faang.lord_of_the_rings_bjs2_80327;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings("checkstyle:CommentsIndentation")
@Slf4j
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character != null && item != null) {
            List<Item> inventory = character.getInventory();
            inventory.add(item);
        } else {
            log.warn("Предмет или персонаж не может быть null");
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character != null) {
            List<Item> inventory = character.getInventory();
            inventory.remove(predicate);
        } else {
            log.warn("Предмет или персонаж не может быть null");
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if (character == null) {
            log.warn("Персонаж не может быть null");
            return;
        }
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (predicate.test(item)) {
                Item updatedItem = function.apply(item);
                inventory.set(i, updatedItem);
            }
        }
    }
}
