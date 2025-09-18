package school.faang.bjs2_87318;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public static void addItem(Character character, Item item, Consumer<Item> additionalMessage) {
        character.getInventory().add(item);
        additionalMessage.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> criteriaForRemoval) {
        character.getInventory().removeIf(criteriaForRemoval);
    }

    public static void updateItem(Character character,
                                  Predicate<Item> criteriaForUpdate, Function<Item, Item> wayToUpdate) {
        List<Item> characterInventory = character.getInventory();
        ListIterator<Item> iterator = characterInventory.listIterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (criteriaForUpdate.test(item)) {
                iterator.remove();
                iterator.add(wayToUpdate.apply(item));
            }
        }
    }
}
