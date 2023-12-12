package faang.school.godbless.lord;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);

    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        for (Item item : character.getInventory()) {
            if (itemPredicate.test(item)) {
                character.getInventory().remove(item);
                break;
            }
        }

    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (itemPredicate.test(item)) {
                Item newItem = function.apply(item);
                character.getInventory().remove(item);
                character.getInventory().add(newItem);
                break;
            }
        }
    }
}
