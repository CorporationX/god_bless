package Lord_of_the_Rings_RPG;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item,
                        Consumer<Item> notificationOfAddition) {
        character.getInventory().add(item);
        notificationOfAddition.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> conditionForRemoving) {
        List<Item> inventory = character.getInventory();
        Iterator<Item> itemIterator = inventory.iterator();
        while (itemIterator.hasNext()) {
            Item nextItem = itemIterator.next();
            if (conditionForRemoving.test(nextItem)) {
                itemIterator.remove();
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> conditionForUpdating,
                           Function<Item, Item> updatingItem) {
        List<Item> inventory = character.getInventory();
        Iterator<Item> itemIterator = inventory.iterator();
        while (itemIterator.hasNext()) {
            Item nextItem = itemIterator.next();
            if (conditionForUpdating.test(nextItem)) {
                updatingItem.apply(nextItem);
            }
        }
    }
}
