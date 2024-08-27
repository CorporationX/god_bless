package faang.school.godbless.fi.ringslord;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character.getInventory().contains(item)) {
            System.out.printf("\n> item already in %s's inventory\n", character.getName());
        } else {
            character.getInventory().add(item);
            consumer.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (!character.getInventory().removeIf(predicate)) {
            System.out.println("\n> no such items in inventory");
        }
    }

    public void updateItem(Character character,
                           Predicate<Item> predicate,
                           Function<Item, Item> function) {

        var inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            if (predicate.test(inventory.get(i))) {
                inventory.set(i, function.apply(inventory.get(i)));
            }
        }
    }

}
