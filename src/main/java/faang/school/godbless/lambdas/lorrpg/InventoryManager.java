package faang.school.godbless.lambdas.lorrpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character == null || item == null || consumer == null) {
            throw new IllegalArgumentException();
        }

        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character == null || predicate == null) {
            throw new IllegalArgumentException();
        }

        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate,
                           Function<Item, Item> function) {

        if (character == null || predicate == null || function == null) {
            throw new IllegalArgumentException();
        }

        character.getInventory()
                .replaceAll(item -> predicate.test(item) ? function.apply(item) : item);
    }
}
