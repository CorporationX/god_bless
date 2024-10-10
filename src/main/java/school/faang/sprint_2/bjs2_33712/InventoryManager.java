package school.faang.sprint_2.bjs2_33712;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.addItem(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.removeItem(predicate);
    }

    public void updateItemValue(Character character, Predicate<Item> predicate, Consumer<Item> updater) {
        character.getInventory().forEach(item -> {
            if (predicate.test(item)) {
                updater.accept(item);
            }
        });
    }
}
