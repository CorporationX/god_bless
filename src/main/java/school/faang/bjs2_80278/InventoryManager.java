package school.faang.bjs2_80278;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> playerNotificationMessage) {
        character.getInventory().add(item);
        playerNotificationMessage.accept(item);
    }

    public void addItem(Character character, Item item) {
        List<Item> inventory = character.getInventory();
        inventory.add(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        List<Item> inventory = character.getInventory();
        Iterator<Item> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            if (condition.test(iterator.next())) {
                iterator.remove();
            }
        }
    }

    public void alternativeRemoveItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> newItem) {
        character.getInventory().replaceAll(e -> {
            if (condition.test(e)) {
                newItem.apply(e);
            }
            return e;
        });
    }
}
