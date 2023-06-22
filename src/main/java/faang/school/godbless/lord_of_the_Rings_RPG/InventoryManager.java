package faang.school.godbless.lord_of_the_Rings_RPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {


    public void addItem(Character inventory, Item item, Consumer<Item> consumer) {
        if (inventory.getInventory().add(item)) {
            consumer.accept(item);
        }
    }

    public void removeItem(Character inventory, Predicate<Item> predicate) {
        if (inventory.getInventory().isEmpty()) {
            throw new IllegalStateException("empty list");
        }

        for (Item item : inventory.getInventory()) {
            if (predicate.test(item)) {
                inventory.getInventory().remove(item);
                return;
            }
        }
    }

    public void updateItem(Character inventory, Predicate<Item> predicate, Function<Item, Item> function) {
        if (inventory.getInventory().isEmpty()) {
            throw new IllegalStateException("empty list");
        }

        for (Item item : inventory.getInventory()) {
            if (predicate.test(item)) {
                function.apply(item);
                return;
            }
        }
    }
}
