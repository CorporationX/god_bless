package school.faang.task_45700;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character unit, Item item, Consumer<Item> action) {
        unit.addInventory(item);
        action.accept(item);
    }

    public void removeItem(Character unit, Predicate<Item> condition) {
        unit.getInventory().removeIf(condition);
    }

    public void updateItem(Character unit, Predicate<Item> condition, Function<Item, Item> action) {
        for (int i = 0; i < unit.getInventory().size(); i++) {
            Item currentItem = unit.getInventory().get(i);
            if (condition.test(currentItem)) {
                unit.getInventory().set(i, action.apply(currentItem));
            }
        }
    }
}
