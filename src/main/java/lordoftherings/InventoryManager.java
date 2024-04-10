package lordoftherings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public static void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> itemPredicate) {
        character.getInventory().removeIf(itemPredicate);
    }

    public static void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> function) {
        List<Item> inventoryOfCharacter = character.getInventory();
        for (int i = 0; i < inventoryOfCharacter.size(); i++) {
            if (itemPredicate.test(inventoryOfCharacter.get(i))) {
                inventoryOfCharacter.set(i, function.apply(inventoryOfCharacter.get(i)));
            }
        }
    }

}
