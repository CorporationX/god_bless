package school.faang.sprint_2.task_45520;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemCondition) {
        character.getInventory().removeIf(itemCondition);
    }

    public void updateItem(Character character, Predicate<Item> itemCondition,  Function<Item, Item> updateAction) {
        List<Item> inventory = character.getInventory();

        for (Item item : inventory) {
            int index = inventory.indexOf(item);
            if (itemCondition.test(item)) {
                inventory.set(index, updateAction.apply(item));
            }
        }
    }

}
