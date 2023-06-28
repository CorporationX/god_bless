package faang.school.godbless.lambda_stream.lord_of_the_rings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public static void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public static void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        character.getInventory().replaceAll(item -> {
            return predicate.test(item) ? function.apply(item) : item;
        });
    }
}