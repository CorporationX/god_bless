package faang;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.remove(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> itemFunction) {
        character.update(predicate, itemFunction);
    }
}

