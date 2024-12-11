package school.faang.task_45532;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> action) {
        List<Item> inventory = character.getInventory();

        List<Item> updatedInventory = Stream.concat(
                inventory.stream().filter(predicate.negate()),
                inventory.stream().filter(predicate).map(action)
        ).toList();

        inventory.clear();
        inventory.addAll(updatedInventory);
    }
}

