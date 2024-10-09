package school.faang.lord.of.the.rings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {

    public static void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public static void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> updatedInventory = character.getInventory().stream()
                .map(item -> predicate.test(item) ? function.apply(item) : item)
                .collect(Collectors.toList());
        character.setInventory(updatedInventory);
    }
}
