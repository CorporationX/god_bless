package school.faang.rpgSystem;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> message) {
        character.getItems().add(item);
        message.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> isTrash) {
        character.getItems().removeIf(isTrash);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updater) {
        List<Item> inventory = character.getItems();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (predicate.test(item)) {
                inventory.set(i, updater.apply(item));
            }
        }
    }
}
