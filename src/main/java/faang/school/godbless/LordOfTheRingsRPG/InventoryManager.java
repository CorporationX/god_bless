package faang.school.godbless.LordOfTheRingsRPG;

import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate::test);
    }

    void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        ListIterator<Item> itemIterator = character.getInventory().listIterator();
        while (itemIterator.hasNext()) {
            Item currentItem = itemIterator.next();
            if (predicate.test(currentItem)) {
                itemIterator.set(function.apply(currentItem));
            }
        }
    }
}
