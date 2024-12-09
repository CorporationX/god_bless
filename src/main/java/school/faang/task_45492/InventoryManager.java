package school.faang.task_45492;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> callBack) {
        character.getItemList().add(item);
        callBack.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        List<Item> inventory = character.getItemList();
        inventory.removeIf(itemPredicate);
    }

    public void updateItem(Character character, Predicate<Item> condition, java.util.function.Function<Item, Item> updater) {
        List<Item> inventory = character.getItemList();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (condition.test(item)) {
                Item updatedItem = updater.apply(item);
                inventory.set(i, updatedItem);
                System.out.println(item.getName() + " обновлён.");
            }
        }
    }
}

