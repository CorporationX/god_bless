package faang.school.godbless.Async.Carry;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> combinedItemFuture = inventory.getFromChest(1000, "Sword", 10)
                .thenCombine(inventory.buy(2000, "Spear", 5), inventory::combineItems)
                .thenComposeAsync(combinedItem -> {
                    inventory.addItem(combinedItem);
                    return CompletableFuture.completedFuture(combinedItem);
                })
                .thenApplyAsync(item -> {
                    System.out.println("Combined items: " + item.getName() + ", " + item.getPower());
                    return item;
                });

        combinedItemFuture.join();
    }
}
