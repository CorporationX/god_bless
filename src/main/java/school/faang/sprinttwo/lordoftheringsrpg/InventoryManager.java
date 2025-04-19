package school.faang.sprinttwo.lordoftheringsrpg;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        List<Item> items = new ArrayList<>();
        items.add(item);
        character.setInventory(items);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> transform) {
        var inventory = character.getInventory();
        inventory.replaceAll(item -> filter.test(item) ? transform.apply(item) : item);
    }
}