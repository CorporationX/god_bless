package school.faang.sprint2.bjs_45539;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character person, Item item, Consumer<Item> action) {
        if (person != null && item != null) {
            person.getInventory().add(item);
            action.accept(item);
        }
    }

    public void removeItem(Character person, Predicate<Item> condition) {
        person.getInventory().removeIf(condition);
    }

    public void updateItem(Character person, Predicate<Item> condition, Function<Item, Item> modifier) {
        List<Item> inventory = person.getInventory();
        inventory.stream()
                .filter(condition)
                .forEach(obj -> inventory.set(inventory.indexOf(obj), modifier.apply(obj)));
    }
}
