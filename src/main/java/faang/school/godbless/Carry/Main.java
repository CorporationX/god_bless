package faang.school.godbless.Carry;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> itemFromChest = Dota2.getItemFromChest();
        CompletableFuture<Item> itemFromShop = Dota2.getItemFromShop();

        CompletableFuture<Item> combinedItem = itemFromChest.thenCombine(itemFromShop, (item1, item2) -> {
            Item item = Inventory.combineItems(item1, item2);
            log.info("Combine a new item {} : {}", item.getName(), item.getPower());
            return item;
        });

        CompletableFuture<Void> result = combinedItem.thenCompose(item -> CompletableFuture.runAsync(() -> {
                inventory.addItem(item);
                log.info("Add item {} to inventory", item.getName());
            })
        );

        try {
            result.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        } catch (ExecutionException e) {
            log.error(e.getMessage());
        }

        log.info("All tasks completed");
    }
}
