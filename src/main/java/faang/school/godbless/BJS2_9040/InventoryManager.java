package faang.school.godbless.BJS2_9040;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> msg) {
        character.getInventory().add(item);
        msg.accept(item);
    }

    public void deleteItem(Character character, Predicate<Item> condition) {
        character.getInventory().stream().filter(condition).toList().forEach(item -> character.getInventory().remove(item));
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updatedItem) {
        character.getInventory().stream().filter(condition).toList().forEach(item -> {
            character.getInventory().remove(item);
            character.getInventory().add(updatedItem.apply(item));
        });
    }
}
