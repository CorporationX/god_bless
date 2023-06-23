package faang.school.godbless;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> function) {
        boolean added = character.getInventory().add(item);
        function.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> checker) {
        character.getInventory().removeIf(checker);
    }

    public void updateItem(Character character, Predicate<Item> checker, Function<Item, Item> updater) {
        var inventory = character.getInventory();
        // Тренировка stream api :)
        character.setInventory(
                inventory.stream()
                        .map(item -> checker.test(item) ? updater.apply(item) : item)
                        .toList()
        );

    }
}
