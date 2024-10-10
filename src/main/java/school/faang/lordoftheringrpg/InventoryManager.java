package school.faang.lordoftheringrpg;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Item item, Consumer<Item> consumer){
        consumer.accept(item);
    }

    public void removeItem(List<Item> items, Predicate<Item> predicate){
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            if (predicate.test(currentItem)) {
                iterator.remove();
            }
        }
    }

    public void updateItem(Item item, List<Item> items, Function<Item, Item> function){
        for(Item currentItem : items){
            if (currentItem.equals(item)){
                Item updatedItem = function.apply(item);
                currentItem.setName(updatedItem.getName());
                currentItem.setPrice(updatedItem.getPrice());
            }
        }
    }
}
