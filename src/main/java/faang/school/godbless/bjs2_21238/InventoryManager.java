package faang.school.godbless.bjs2_21238;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        var inventory = character.getInventory();
        var items = inventory.stream()
                .filter(predicate)
                .toList();
        var last = items.size() - 1;
        for (int i = 0; i <= last; i++) {
            var item = items.get(i);
            inventory.set(i, function.apply(item));
        }
    }
}
