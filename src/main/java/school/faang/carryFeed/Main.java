package school.faang.carryFeed;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.initializeRandomItems(100);
        List<Item> chestItems = inventory.pickItemsByType(ItemType.CHEST);
        List<Item> shopItems = inventory.pickItemsByType(ItemType.SHOP);
        int minItems = Math.min(chestItems.size(), shopItems.size());

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i=0; i<minItems; i++) {
            CompletableFuture<Void> future = inventory.getItemByTypeAndRemove(ItemType.CHEST)
                    .thenCombine(inventory.getItemByTypeAndRemove(ItemType.SHOP), inventory::combineItems)
                    .thenCompose(combinedItem -> CompletableFuture.runAsync(() -> {
                        inventory.addItem(combinedItem);
                        System.out.println("Added combined item: " + combinedItem.getName());
                    }));

            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }
}
