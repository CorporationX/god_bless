package school.faang.sprint_2.task_45594;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        character.getInventory().removeIf(itemPredicate);
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate,
                           Function<Item, Item> itemIntegerFunction) {

        List<Item> updatedItems = character.getInventory().stream()
            .filter(itemPredicate)
            .map(itemIntegerFunction)
            .toList();

        List<Item> newItemlist = character.getInventory().stream()
            .filter(item -> !itemPredicate.test(item))
            .toList();

        character.getInventory().clear();
        character.getInventory().addAll(updatedItems);
        character.getInventory().addAll(newItemlist);
    }
}
