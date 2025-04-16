package school.faang.bjs2_70032;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public List<Item> addItem(Character character, Item item, Consumer<Item> action) {
        List<Item> inventory = character.addInventoryItem(item);
        action.accept(item);
        return inventory;
    }

    public boolean removeItem(Character character, Predicate<Item> filter) {
        return character.removeItem(filter);
    }

    public Item updateItem(Character character, Predicate<Item> filter, Function<Item, Item> converter) {
        return character.updateItem(filter, converter);
    }
}