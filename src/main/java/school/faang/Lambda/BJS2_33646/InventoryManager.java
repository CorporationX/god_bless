package school.faang.Lambda.BJS2_33646;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Consumer<Item> updater) {
        character.getInventory().stream()
                .filter(predicate)
                .forEach(updater);
    }
}
