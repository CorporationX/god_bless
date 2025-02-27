package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Inventory {
    private final List<Item> items = new ArrayList<>();
    private static final int GETTING_FROM_CHEST_LATENCY_MS = 2000;
    private static final int GETTING_FROM_SHOP_LATENCY_MS = 2000;

    public void addItem(Item item) {
        items.add(item);
        log.info("Item {} added to inventory", item.getName());
    }

    public Item combineItems(Item first, Item second) {
        return new Item(first.getName() + second.getName(), first.getPower() + second.getPower());
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(GETTING_FROM_CHEST_LATENCY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Sleep interrupted in \"getItemFromChest\"");
            }
            return new Item("Item from chest", 10);
        });
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(GETTING_FROM_SHOP_LATENCY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Sleep interrupted in \"getItemFromShop\"");
            }
            return new Item("Item from shop", 30);
        });
    }
}
