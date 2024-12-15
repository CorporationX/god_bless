package school.faang.task_45514;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
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
        if (character.getInventory().stream().anyMatch(it->condition.test(it))) {
            character.getInventory().stream().forEach(item -> {
                if ((condition.test(item))){
                    item.setValue(function.apply(item).getValue());
                }
            });
        } else {
            System.out.println("There is no such item.");
        }

    }
}