package faang.school.godbless.lambdas.task_8.util;

import faang.school.godbless.lambdas.task_8.model.Character;
import faang.school.godbless.lambdas.task_8.model.Item;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> inventoryHandler) {
        character.getInventory().add(item);
        inventoryHandler.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        List<Item> items = character.getInventory();
        items.removeIf(condition);
    }


    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> converter) {
        List<Item> items = character.getInventory();
        for (int index = 0; index < items.size(); index++) {
            Item checkedItem = items.get(index);
            if (condition.test(checkedItem)) {
                items.set(index, converter.apply(checkedItem));
            }
        }
    }
}