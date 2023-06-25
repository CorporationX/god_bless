package faang.school.godbless.lambda.lords;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getItemList().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate, Consumer<Item> consumer) {
        for (Item item : character.getItemList()) {
            if (predicate.test(item)) {
                character.getItemList().remove(item);
                consumer.accept(item);
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> itemList = character.getItemList();
//        Iterator<Item> it = itemList.iterator();
//
//        while (it.hasNext()) {
//
//        }

        for (Item item : itemList) {
            if (predicate.test(item)) {
                int index = itemList.indexOf(item);
                itemList.set(index, function.apply(item));
            }
        }
    }
}
