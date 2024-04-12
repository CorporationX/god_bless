package LordoftheRingsRPG;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (item == null || character.getInventory() == null) {
            throw new RuntimeException("Item or inventory or null.");
        }
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> items = character.getInventory();
        items.removeIf(predicate);
        System.out.println("Item removed.");
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> update) {
        List<Item> items = character.getInventory();
        for (int i = 0; i < items.size(); i++) {
            if (predicate.test(items.get(i))) {
                character.getInventory().set(i, update.apply(items.get(i)));
            }
        }
        System.out.println("Item update.");
    }
}
