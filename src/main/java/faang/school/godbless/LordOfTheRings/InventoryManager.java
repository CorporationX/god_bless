package faang.school.godbless.LordOfTheRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item itemToAdd, Consumer<Item> consumer) {
        character.inventory.add(itemToAdd);
        consumer.accept(itemToAdd);
    }
    public void removeItem(Character character, Predicate<Item> predicate) {
        character.inventory.removeIf(predicate);
    }
    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function ) {
        for (Item item : character.inventory) {
            if (predicate.test(item)) {
                function.apply(item);
            }
        }
    }
}
