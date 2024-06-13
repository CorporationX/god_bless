package faang.school.godbless.BJS2_9106;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        if (character == null || item == null || action == null) {
            throw new IllegalArgumentException("Some arguments was illegal");
        }

        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        if (character == null || condition == null) {
            throw new IllegalArgumentException("Some arguments was illegal");
        }

        List<Item> inventory = character.getInventory();

        for (var item: inventory) {
            if (condition.test(item)) {
                inventory.remove(item);
                break;
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> func) {
        if (character == null || condition == null || func == null) {
            throw new IllegalArgumentException("Some arguments was illegal");
        }

        List<Item> inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);

            if (condition.test(item)) {
                inventory.set(i, func.apply(item));
                break;
            }
        }
    }
}
