package com.functional.lord;

import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        ListIterator<Item> iterator = character.getInventory().listIterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (predicate.test(item)) {
                iterator.set(function.apply(item));
            }
        }
    }
}
