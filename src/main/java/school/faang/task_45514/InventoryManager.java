package school.faang.task_45514;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> printInformation) {
        if (character == null || item == null || printInformation == null) {
            throw new IllegalArgumentException("Check input data. One of the objects is null");
        }
        character.getInventory().add(item);
        printInformation.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        List<Item> itemsToRemove = new ArrayList<>();
        if (character == null || condition == null) {
            throw new IllegalArgumentException("Check input data. One of the objects is null");
        }
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> function) {
        if (character == null || function == null) {
            throw new IllegalArgumentException("Check input data. One of the objects is null");
        }
        List<Item> items = character.getInventory();
        Item item = items.stream().filter(it -> condition.test(it)).findFirst().orElse(null);
        if (item == null) {
            return;
        }
        items.set(items.indexOf(item), function.apply(item));
    }
}