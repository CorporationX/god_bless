package school.faang.lord_of_the_rings_rpg;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> adder) {
        character.getInventory().add(item);
        adder.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> toDelete) {
        List<Item> inventory = character.getInventory();
        inventory.removeIf(toDelete);
    }

    public void updateItem(Character character, Predicate<Item> toUpdate, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();
        int k = 0;
        for (Item item : inventory) {
            if (toUpdate.test(item)) {
                inventory.set(k, updater.apply(item));
            }
            k++;
        }
    }
}
