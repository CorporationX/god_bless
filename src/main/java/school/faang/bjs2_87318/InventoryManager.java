package school.faang.bjs2_87318;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public static void addItem(Character character, Item item, Consumer<Item> additionalMessage) {
        character.addItem(item);
        additionalMessage.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> criteriaForRemoval) {
        character.getInventory().removeIf(criteriaForRemoval);
    }

    public static void updateItem(Character character,
                                  Predicate<Item> criteriaForUpdate, Function<Item, Item> wayToUpdate) {
        List<Item> characterInventory = character.getInventory();
        for (int i = 0; i < characterInventory.size(); i++) {
            Item item = characterInventory.get(i);
            if (criteriaForUpdate.test(item)) {
                character.removeItem(item);
                character.addItem(wayToUpdate.apply(item));
            }
        }
    }
}
