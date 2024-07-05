package faang.school.godbless.async.carry;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Inventory inventory = new Inventory(executorService);
        List<Item> items = getItems();
        Item randomItem = items.get(new Random().nextInt(items.size()));
        CompletableFuture<Item> fromChest = inventory.getFromChest(items);
        CompletableFuture<Item> fromShop = inventory.getFromShop(randomItem);
        fromChest.thenCombine(fromShop, inventory::combine)
                .thenCompose(item -> CompletableFuture.runAsync(() -> {
                    inventory.addItem(item);
                    log.info("{} added item", item);
                })).join();
        executorService.shutdown();
    }

    private static List<Item> getItems(){
        return List.of(
                new Item("Sword",12),
                new Item("Axe", 14),
                new Item("Neck",8),
                new Item("Boots",10),
                new Item("Ring",8)
        );
    }
}
