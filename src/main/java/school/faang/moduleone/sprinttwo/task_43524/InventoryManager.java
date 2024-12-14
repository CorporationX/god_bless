package school.faang.moduleone.sprinttwo.task_43524;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public boolean removeItem(Character character, Item item, Predicate<Item> condition) {
        boolean isItemRemoved = false;
        if (condition.test(item)) {
            isItemRemoved = character.getInventory().remove(item);
        }
        return isItemRemoved;
    }

    public void updateItem(Character character, Predicate<Item> condition, Consumer<Item> action) {
        character.getInventory().stream()
                .filter(condition)
                .forEach(action);
    }
}
