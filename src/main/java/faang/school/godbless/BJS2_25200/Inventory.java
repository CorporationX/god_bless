package faang.school.godbless.BJS2_25200;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@AllArgsConstructor
public class Inventory {
    private final Object lockItems = new Object();

    private ExecutorService executor;
    private List<Item> items;

    public void addItem(ItemStore store) {
        CompletableFuture<Item> item = CompletableFuture.supplyAsync(this::getItem);
        CompletableFuture<Item> newItem = CompletableFuture.supplyAsync(store::removeItem);
        CompletableFuture<Item> combineItem = item.thenCombineAsync(newItem, store::combineItems);

        combineItem.thenComposeAsync(result -> CompletableFuture.runAsync(
                () -> addItem(result, item)
        )).join();
    }

    private void addItem(Item combineItem, CompletableFuture<Item> oldItemFuture) {
        try {
            Item oldItem = oldItemFuture.get();
            if (!combineItem.equals(oldItem)) {
                synchronized (lockItems) {
                    items.remove(oldItem);
                    items.add(combineItem);
                }
                System.out.println("Новый элемент получен!");
            } else {
                System.out.println("Новый элемент НЕ получен!");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    private Item getItem() {
        if (items.isEmpty()) {
            throw new IllegalStateException("No items in Inventory");
        }

        int index = ThreadLocalRandom.current().nextInt(items.size());
        return items.get(index);
    }
}
