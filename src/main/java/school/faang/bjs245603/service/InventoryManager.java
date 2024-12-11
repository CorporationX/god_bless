package school.faang.bjs245603.service;

import lombok.AllArgsConstructor;
import school.faang.bjs245603.model.Character;
import school.faang.bjs245603.model.Item;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor
public class InventoryManager {
    public static void add(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public static void remove(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public static void update(Character character, Predicate<Item> filter, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory().stream()
                .filter(filter)
                .map(function)
                .toList();
        character.setInventory(inventory);
    }
}
