package faang.school.godbless.LordOfTheRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character == null || item == null) {
            return;
        }

        character.addItem(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character == null || predicate == null) {
            return;
        }

        character.removeItem(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        character.getItems(predicate).forEach(item -> {
            item.update(function.apply(item));
        });
    }
}
