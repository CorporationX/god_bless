package school.faang.bjs245540;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character == null || item == null || consumer == null) {
            throw new IllegalArgumentException("Arguments must be not null !!!");
        }
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        if (character == null || condition == null) {
            throw new IllegalArgumentException("Arguments must be not null !!!");
        }
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        if (character == null || condition == null || updater == null) {
            throw new IllegalArgumentException("Arguments must be not null !!!");
        }

        for (int i = 0; i < character.getInventory().size(); i++) {
            Item item = character.getInventory().get(i);
            if (condition.test(item)) {
                Item updatedItem = updater.apply(item);
                character.getInventory().set(i, updatedItem);
            }
        }
    }
}
