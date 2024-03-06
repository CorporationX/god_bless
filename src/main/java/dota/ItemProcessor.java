package dota;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ItemProcessor {
    private PlayerInventory playerInventory;

    public ItemProcessor(PlayerInventory playerInventory) {
        this.playerInventory = playerInventory;
    }

    public CompletableFuture<Item> getFirstItemFromChestAsync() {
        return CompletableFuture.supplyAsync(() -> new Item("Sacred Relic", 10));
    }

    public CompletableFuture<Item> getSecondItemFromShopAsync() {
        return CompletableFuture.supplyAsync(() -> new Item("Talisman of evasion", 5));
    }

    public CompletableFuture<Item> combineItemsAsync(Item item1, Item item2) {
        return CompletableFuture.supplyAsync(() -> new Item("Radiance", item1.getPower() + item2.getPower()));
    }

    public CompletableFuture<Void> addItemToInventoryAsync(Item item) {
        return CompletableFuture.runAsync(() -> playerInventory.addItems(List.of(item)));
    }
}
