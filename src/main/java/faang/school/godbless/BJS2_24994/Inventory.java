package faang.school.godbless.BJS2_24994;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    List<Item> items;

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combinedItem(Item item1, Item item2) {

    }

    public CompletableFuture<Item> getItem (List<Item>items) {
        return CompletableFuture.supplyAsync(()->)
    }
}
