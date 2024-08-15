package faang.school.godbless.LOTR;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (item != null) {
            character.getInventory().add(item);
            consumer.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> itemsToRemove = new ArrayList<>();
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                itemsToRemove.add(item);
            }
        }
        character.getInventory().removeAll(itemsToRemove);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> updateItems = new ArrayList<>();
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                updateItems.add(function.apply(item));
            }
        }
    }
}
