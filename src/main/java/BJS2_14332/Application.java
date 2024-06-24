package BJS2_14332;

import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CompletableFuture<Item> fromChest = inventory.getFromChest();
        CompletableFuture<Item> bought = inventory.buy();

        fromChest.thenCombine(bought, inventory::combine)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.add(item)));

        System.out.println(inventory.getItems());

    }
}
