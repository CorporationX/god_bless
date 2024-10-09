package school.faang.lordofrherings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        itemConsumer.accept(item);
        List<Item> items = character.getInventory();
        items.add(item);
    }

    public void removeItem(Character character, Item item, Predicate<Item> itemPredicate) {
        List<Item> items = character.getInventory();
        if (itemPredicate.test(item)) {
            items.remove(item);
        }
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
       List<Item> items = character.getInventory();
       for (int i = 0; i < items.size(); i++) {
           Item item = items.get(i);
           if (itemPredicate.test(item)) {
               items.set(i, itemFunction.apply(item));
           }
       }
    }
}
