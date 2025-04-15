package school.faang.bjs2_69976;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> itemAdder) {
        character.getInventory().add(item);
        itemAdder.accept(item);
    }

    public void removeItem(Character character, Item item, Predicate<Item> itemPresenceChecker) {
        boolean isRemoved = character.getInventory().removeIf(itemPresenceChecker);
        if (isRemoved) {
            System.out.println(item.getName() + " removed");
        } else {
            System.out.println(item.getName() + " not found");
        }
    }

    public void updateItem(Character character, Predicate<Item> itemPresenceChecker,
                           Function<Item, Item> updater) {
        List<Item> items = character.getInventory();
        for (Item itemInList : items) {
            if (itemPresenceChecker.test(itemInList)) {
                updater.apply(itemInList);
            }
        }
    }
}
