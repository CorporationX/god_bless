package school.faang.stream2.lotrrpg;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public boolean addItem(Character character, Item item, Consumer<Item> consumer) {
        boolean add = character.getInventory().add(item);
        consumer.accept(item);
        return add;
    }

    public boolean removeItem(Character character, Predicate<Item> predicate) {
        return character.getInventory().removeIf(predicate);
    }

    public boolean updateItem(Character character, Predicate<Item> criteria, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        Optional<Item> itemOptional =
                inventory.stream()
                        .filter(criteria)
                        .findFirst().map(original -> {
                    Item updated = function.apply(original);
                    int originalIndex = inventory.indexOf(original);
                    inventory.set(originalIndex, updated);
                    return updated;
                });
        return itemOptional.isPresent();
    }
}
