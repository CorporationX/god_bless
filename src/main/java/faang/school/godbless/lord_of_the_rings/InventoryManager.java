package faang.school.godbless.lord_of_the_rings;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
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
            if (predicate.test(item)) {
                return function.apply(item);
            }
            return item;
        });
    }
}

@AllArgsConstructor
@Getter
class Character {
    private String name;
    private List<Item> inventory;
}

@AllArgsConstructor
@Getter
class Item {
    private String name;
    private int value;
}