package faang.school.godbless;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character.getInventory() == null) {
            character.setInventory(new ArrayList<>());
        }
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter,
                           Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (filter.test(item)) {
                function.apply(item);
            }
        }
    }
}
