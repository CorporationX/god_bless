package bjs2_37882;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public Item combineItems(Item firstItem, Item secondItem) {
        String combinedItemName = firstItem.getName() + secondItem.getName();
        int combinedItemPower = firstItem.getPower() + secondItem.getPower();
        Item combinedItem = new Item(combinedItemName, combinedItemPower);

        addItem(combinedItem);
        removeItem(firstItem);
        removeItem(secondItem);

        return combinedItem;
    }

    public Item buyItem(Shop shop, Item item) {
        Item boughtItem = shop.sell(item);
        addItem(boughtItem);
        return boughtItem;
    }

    public synchronized Item getItem(Item item) {
        if (items.contains(item)) {
            return item;
        } else {
            throw new IllegalArgumentException("Item not in inventory");
        }
    }

    public synchronized void addItem(Item item) {
        items.add(item);
    }

    private synchronized void removeItem(Item item) {
        items.remove(item);
    }
}
