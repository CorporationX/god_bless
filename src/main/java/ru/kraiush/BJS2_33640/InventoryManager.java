package ru.kraiush.BJS2_33640;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventories().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventories().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> action) {
        List<Item> items = character.getInventories();
        for (int i = 0; i < items.size(); i++) {
            Item currentItem = items.get(i);
            if (condition.test(currentItem)) {
                items.set(i, action.apply(currentItem));
            }
        }
    }
}
