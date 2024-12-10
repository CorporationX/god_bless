package school.faang.sprint_2.task_45520;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character == null || item == null || consumer == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemCondition) {
        if (character == null || itemCondition == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        character.getInventory().removeIf(itemCondition);
    }

    public void updateItem(Character character, Predicate<Item> itemCondition, Function<Item, Item> updateAction) {
        if (character == null || itemCondition == null || updateAction == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }

        List<Item> inventory = character.getInventory();
        Iterator<Item> iterator = inventory.iterator();

        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (itemCondition.test(item)) {
                updateAction.apply(item);
            }
        }

    }
}
