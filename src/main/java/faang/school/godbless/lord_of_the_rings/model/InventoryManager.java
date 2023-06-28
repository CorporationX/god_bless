package faang.school.godbless.lord_of_the_rings.model;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
            character.addItem(item);
            consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        emptyCheck(character);
        Iterator<Item> itemIterator = character.getInventory().iterator();
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            if (predicate.test(item)) {
                itemIterator.remove();
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        emptyCheck(character);
        ListIterator<Item> itemIterator = character.getInventory().listIterator();
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            if (predicate.test(item)) {
                itemIterator.set(function.apply(item));
            }
        }
    }

    private void emptyCheck(Character character) {
        if (character.getInventory() == null || character.getInventory().isEmpty()) {
            throw new IllegalArgumentException("inventory is empty");
        }
    }

}
