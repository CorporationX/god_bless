package bjs2_90658;

import java.util.function.*;
import java.util.*;

public class InventoryManager {

    // Добавление предмета
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);  // действие над предметом
    }

    // Удаление предмета
    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    // Обновление предмета
    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (predicate.test(item)) {
                inventory.set(i, updater.apply(item));  // заменить на обновленный предмет
            }
        }
    }
}