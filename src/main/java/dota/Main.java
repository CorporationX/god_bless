package dota;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        PlayerInventory inventory = new PlayerInventory();

        ItemProcessor processor = new ItemProcessor(inventory);

        CompletableFuture<Void> result = processor.getFirstItemFromChestAsync()
                .thenCombine(processor.getSecondItemFromShopAsync(), (item1, item2) ->
                        processor.combineItemsAsync(item1, item2).join())
                .thenComposeAsync(processor::addItemToInventoryAsync);

        result.join();

        System.out.println("Player's Inventory: " + inventory.getItems());
    }
}
