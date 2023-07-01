package faang.school.godbless.sprint_3.lord_of_the_rings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> items = character.getInventory();
        items.stream()
                .filter(predicate)
                .findFirst()
                .ifPresent(items::remove);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if (!character.getInventory().isEmpty()) {
            character.getInventory().stream()
                    .filter(predicate)
                    .forEach(item -> {
                        Item newItem = function.apply(item);
                        int index = character.getInventory().indexOf(item);
                        character.getInventory().set(index, newItem);
                    });
        }
    }
}