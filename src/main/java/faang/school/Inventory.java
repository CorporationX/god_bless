package faang.school;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    List<Item> items = new ArrayList<>();

    public synchronized void addItem(Item item) {
        items.add(item);
    }

    public CompletableFuture<Item> combineItems(Item item1, Item item2) {
        return CompletableFuture.supplyAsync(() -> {
            var newItem = new Item(item1.getName() + " " + item2.getName(),
                    item1.getPower() + item2.getPower());
            return newItem;
        });
    }
}
