package school.faang.task_50724;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Data
public class Inventory {
    private final List<Item> items;

    public void addItem(Item item) {
        items.add(item);
    }

    private Item combineItems(Item item1, Item item2) {
        return new Item(item1.name() + item2.name(), item1.power() + item2.power());
    }

    public CompletableFuture<Item> getFirstItem() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) (Math.random() * 2000));
            } catch (InterruptedException e) {
                log.error("Ошибка выполнения потока: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }

            return new Item("First Item", (int) (Math.random() * 10));
        });
    }

    public CompletableFuture<Item> getSecondItem() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) (Math.random() * 2000));
            } catch (InterruptedException e) {
                log.error("Ошибка выполнения потока: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }

            return new Item("Second Item", (int) (Math.random() * 10));
        });
    }

    public CompletableFuture<Item> combiningItems() {
        return getFirstItem().thenCombine(getSecondItem(), this::combineItems)
                .thenCompose(newItem -> {
                    addItem(newItem);
                    return CompletableFuture.completedFuture(newItem);
                });
    }
}
