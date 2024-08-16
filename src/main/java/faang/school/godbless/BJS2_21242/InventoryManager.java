package faang.school.godbless.BJS2_21242;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character.getInventory().isEmpty()) {
            throw new IllegalArgumentException("Can't remove: Inventory is empty");
        }

        character.getInventory().removeIf(predicate);

    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if (character.getInventory().isEmpty()) {
            throw new IllegalArgumentException("Can't update: Inventory is empty");
        }

        character.getInventory().replaceAll(item -> predicate.test(item) ? function.apply(item) : item);
    }

}
