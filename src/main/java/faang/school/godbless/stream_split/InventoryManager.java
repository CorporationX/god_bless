package faang.school.godbless.stream_split;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character ch, Item item, Consumer<Item> consumer) {
        List<Item> items = new ArrayList<>();
        items.add(item);
        ch.setInventory(items);

        consumer.accept(item);
    }

    public void removeItem(Character ch, Predicate<Item> pred) {
        ch.getInventory().removeIf(pred);
    }

    public void updateItem(Character ch, Predicate<Item> pred, Function<Item, Item> update) {
        for (int itemInx = 0; itemInx < ch.getInventory().size(); itemInx++) {
            Item updItem = ch.getInventory().get(itemInx);
            if (pred.test(ch.getInventory().get(itemInx))) {
                ch.getInventory().set(itemInx, update.apply(updItem));
            }
        }
    }
}
