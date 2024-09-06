package BJS2_25103_CarryIsFed;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> fromChest = inventory.getItemFromChest();
        CompletableFuture<Item> fromSeller = inventory.getItemFromSeller();

        fromChest.thenCombine(fromSeller, inventory::combine)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.add(item)))
                .join();
    }
}
