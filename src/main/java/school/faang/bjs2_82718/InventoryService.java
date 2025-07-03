package school.faang.bjs2_82718;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
public class InventoryService {
    private ItemService itemService;

    public CompletableFuture<Item> combineItems(Inventory inventory) {
        CompletableFuture<Item> future = itemService.getItemFromChest();
        return future.thenCombine(itemService.getItemFromShop(), inventory::combineItems)
                .thenCompose(combinedItem -> CompletableFuture.supplyAsync(
                        () -> {
                            inventory.addItem(combinedItem);
                            return combinedItem;
                        })
                );

    }
}
