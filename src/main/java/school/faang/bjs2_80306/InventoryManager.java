package school.faang.bjs2_80306;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> handler) {
        character.inventory().add(item);
        handler.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.inventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> itemUpdater) {
        List<Item> inventory = character.inventory();

        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (predicate.test(item)) {
                inventory.set(i, itemUpdater.apply(item));
            }
        }
    }
}
