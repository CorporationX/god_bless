package school.faang.task_45514;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> printInformation) {
        if (character == null || item == null || printInformation == null) {
            return;
        }
        character.getInventory().add(item);
        printInformation.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        List<Item> itemsToRemove = new ArrayList<>();
        if (character == null || condition == null) {
            return;
        }
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> function) {
        if (character == null || function == null) {
            return;
        }
        for (Item item : character.getInventory()) {
            if (condition.test(item)) {
                double value = function.apply(item).getValue();
                item.setValue(value);
            }
        }
    }
}