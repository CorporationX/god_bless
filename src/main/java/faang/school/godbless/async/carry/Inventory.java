package faang.school.godbless.async.carry;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@Getter
public class Inventory {
    private ExecutorService executor;
    private List<Item> items;
    private final long DURATION_SHOPPING = 500L;
    private final long DURATION_GET_ITEM_FROM_CHEST = 200L;

    public Inventory(ExecutorService executor) {
        this.executor = executor;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (item == null) {
            log.error("item is null");
            throw new NullPointerException("item is null");
        }
        items.add(item);
    }

    public Item combine(Item first, Item second) {
        if (first == null || second == null) {
            log.error("first or second is null");
            throw new NullPointerException("firstItem or secondItem is null");
        }
        return new Item("New combine Item", first.power() + second.power());
    }

    public CompletableFuture<Item> getFromChest(List<Item> chestItems) {
        Random random = new Random();
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(DURATION_GET_ITEM_FROM_CHEST);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return chestItems.get(random.nextInt(chestItems.size()));
        }, executor);
    }

    public CompletableFuture<Item> getFromShop(Item item) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(DURATION_SHOPPING);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return item;
        }, executor);
    }
}
