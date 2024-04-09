package faang.school.godbless.LordOfTheRings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (item == null || character == null) {
            return;
        }
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character == null) {
            return;
        }
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if (character == null) {
            return;
        }
        List<Item> newInventory = character.getInventory().stream().
                filter(predicate).
                map(function).
                collect(Collectors.toList());
        character.setInventory(newInventory);
    }
}
