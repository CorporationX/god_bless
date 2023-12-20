package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.lordoftherings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Alexander Bulgakov
 */

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        character.getInventory().removeIf(itemPredicate);
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate,
                           Function<Item, Item> itemFunction) {
        List<Item> characterInventory = character.getInventory();

        for (int i = 0; i < characterInventory.size(); i++) {
            if (itemPredicate.test(characterInventory.get(i))) {
                characterInventory.set(i, itemFunction.apply(characterInventory.get(i)));
            }
        }
    }
}
