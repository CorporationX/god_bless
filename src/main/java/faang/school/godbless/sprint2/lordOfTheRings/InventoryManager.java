package faang.school.godbless.sprint2.lordOfTheRings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public boolean removeItem(Character character, Predicate<Item> predicate) {
        return character.getInventory().removeIf(predicate);
    }

    public boolean updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        boolean rsl = false;
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            if (predicate.test(inventory.get(i))) {
                inventory.set(i, function.apply(inventory.get(i)));
                rsl = true;
            }
        }
        return rsl;
    }
}
