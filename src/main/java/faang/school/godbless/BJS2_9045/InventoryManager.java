package faang.school.godbless.BJS2_9045;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        character.getInventory().replaceAll(item -> predicate.test(item) ? function.apply(item) : item);
    }
}
