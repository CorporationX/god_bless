package school.faang.Lambda.BJS2_33646;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {
    private Character character;

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(item -> {
            if (predicate.test(item)) {
                System.out.println(item.getName() + " выброшен");
                return true;
            }
            return false;
        });
    }

    public void updateItem(Character character, Predicate<Item> predicate, Consumer<Item> updater) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                updater.accept(item);
            }
        }
    }
}
