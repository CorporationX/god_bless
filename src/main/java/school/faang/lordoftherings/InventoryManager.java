package school.faang.lordoftherings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    private static final String EXCEPTION_MESSAGE = "One of the arguments is null";

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (consumer == null || character == null || item == null) {
            throw new NullPointerException(EXCEPTION_MESSAGE);
        }
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (predicate == null || character == null) {
            throw new NullPointerException(EXCEPTION_MESSAGE);
        }
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if (function == null || character == null || predicate == null) {
            throw new NullPointerException(EXCEPTION_MESSAGE);
        }
        character.getInventory().replaceAll(item ->
                predicate.test(item) ? function.apply(item) : item
        );
    }
}
