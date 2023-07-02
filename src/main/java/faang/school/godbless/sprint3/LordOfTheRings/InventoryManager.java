package faang.school.godbless.sprint3.LordOfTheRings;

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

    public void removeItem(Character character, Predicate<Item> check) {
        List<Item> inventory = character.getInventory();
        inventory.removeIf(check);
    }

    public void updateItem(Character character, Predicate<Item> check, Function<Item, Item> update) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); ++i) {
            Item item = inventory.get(i);
            if (check.test(item)) {
                inventory.set(i, update.apply(item));
            }
        }
    }
}
