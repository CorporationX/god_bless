package school.faang.lord_of_the_rings;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Проект: god_bless
 * Класс InventoryManager
 * Автор: Vital
 * Дата: 22.09.2025
 */

public class InventoryManager {
    public void addItem(Character character, @NonNull Item item, Consumer<Item> afterAdd) {
        character.getInventory().add(item);
        afterAdd.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (condition.test(item)) {
                inventory.set(i, updater.apply(item));
            }
        }
    }
}