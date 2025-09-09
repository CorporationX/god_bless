package school.faang.bjs2_87365.character;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    private InventoryManager() {

    }

    public static void addItem(Character character, Item item, Consumer<Item> additionalAction) {
        character.inventory().add(item);
        additionalAction.accept(item);
    }

    public static void removeItem(Character character, Item item, Predicate<Item> condition) {
        if (condition.test(item)) {
            character.inventory().remove(item);
        }
    }

    public static void updateItem(Character character, Item item, Function<Item, Item> updater) {
        List<Item> inventory = character.inventory();
        inventory.set(inventory.indexOf(item), updater.apply(item));
    }
}
