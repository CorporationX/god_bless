package school.faang.bsj2_90800;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.inventory.add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.inventory.removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (Item item : character.inventory) {
            if (predicate.test(item)) {
                Item modifiedItem = function.apply(item);
                character.inventory.remove(item);
                character.inventory.add(modifiedItem);
            }
        }
    }
}

