package school.faang.carry;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static school.faang.carry.ThreadPoolProvider.executor;

@Slf4j
public class ItemInventory {
    private final List<Item> items = new ArrayList<>();

    public synchronized void addItem(Item item) {
        Objects.requireNonNull(item);
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        Objects.requireNonNull(item1);
        Objects.requireNonNull(item2);
        return new Item("super item", getCombinedPower(item1.getPower(), item2.getPower()));
    }

    public Item getItemFromBox() {
        return new Item("item from box", 1);
    }

    public Item getItemFromShop() {
        return new Item("item from shop", 3);
    }

    public void getCombinedItem() {
        CompletableFuture<Void> combinedItemAddedFuture = CompletableFuture.supplyAsync(this::getItemFromBox, executor)
                .thenCombine(CompletableFuture.supplyAsync(this::getItemFromShop, executor), this::combineItems)
                .thenCompose(combinedItem -> CompletableFuture.runAsync(() -> addItem(combinedItem), executor));
        combinedItemAddedFuture.join();
        log.info("Combined items added, inventory: {}", items);
    }

    private int getCombinedPower(int power1, int power2) {
        return power1 + power2;
    }
}
