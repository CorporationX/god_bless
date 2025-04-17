package school.faang.stream2.lotrrpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public boolean addItem(Character character, Item item, Consumer<Item> consumer) {
        return false;
    }

    public boolean removeItem(Character character, Predicate<Item> predicate) {
        return false;
    }

    public boolean updateItem(Character character, Predicate<Item> criteria, Function<Item, Item> function) {
        return false;
    }
}
