package school.faang.task215.manager;

import school.faang.task215.character.Character;
import school.faang.task215.item.Item;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public static void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.addNewItem(item);
        consumer.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> predicate) {
        for (Item item : character.getCharacterStuff()) {
            if (predicate.test(item)) {
                character.removeItem(item);
            }
        }
    }

    public static void updateItem(Character character, Predicate<Item> predicate, Function<Item, Integer> function) {
        for (Item item : character.getCharacterStuff()) {
            if (predicate.test(item)) {
                item.setValue(function.apply(item));
            }
        }
    }
}
