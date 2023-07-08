package faang.school.godbless.sprint4.dota;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Data
public class Inventory {
    private List<Item> items = new ArrayList<>();

    public synchronized void addItem(Item item) {
        items.add(item);
    }

    public CompletableFuture<Void> addItemAsync(Item item) {
        return CompletableFuture.runAsync(() -> {
            addItem(item);
        });
    }

    public Item combineItems(Item item1, Item item2) {
        String name = item1.getName() + "_"+ item2.getName();
        int power = item1.getPower() + item2.getPower();
        return new Item(name, power);
    }
    public CompletableFuture<Void> combineItemsAsync(Item item1, Item item2) {
        return CompletableFuture.runAsync(() -> {
            Item result = combineItems(item1, item2);
        });
    }
}
