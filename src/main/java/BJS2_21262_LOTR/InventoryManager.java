package BJS2_21262_LOTR;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public static void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> itemPredicate) {
        character.getInventory().removeIf(itemPredicate);
    }

    public static void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (itemPredicate.test(item)) {
                item.setValue(function.apply(item).getValue());
            }
        }
    }
}
