package faang.school.godbless.lord.of.rings.rpg;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        List<Item> inventory = character.getInventory();
        inventory.add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> inventory = character.getInventory();
        if (inventory != null && !inventory.isEmpty()) {
            inventory.removeIf(predicate);
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        if (inventory != null && !inventory.isEmpty()) {
            for (int i = 0; i < inventory.size(); i++) {
                Item item = inventory.get(i);
                if (predicate.test(item)) {
                    inventory.set(i, function.apply(item));
                }
            }
        }
    }
}
