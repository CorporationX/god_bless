package faang.school.godbless.lordoftherings;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        Iterator<Item> iterator = character.getInventory().iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (itemPredicate.test(item)) {
                iterator.remove();
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate,
                           Function<Item, Item> itemItemFunction) {

        for (int i = 0; i < character.getInventory().size(); i++) {
            Item item = character.getInventory().get(i);
            if (itemPredicate.test(item)) {
                character.getInventory().set(i, itemItemFunction.apply(item));
            }
        }
    }
}
