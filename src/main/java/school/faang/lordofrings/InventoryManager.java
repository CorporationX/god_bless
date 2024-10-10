package school.faang.lordofrings;

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

    public static void updateCharactersItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        character.setInventory(character.getInventory().stream()
                .filter(predicate)
                .map(item -> function.apply(item))
                .toList());
    }
}