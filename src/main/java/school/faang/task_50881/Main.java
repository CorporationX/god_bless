package school.faang.task_50881;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Inventory inventory = new Inventory();
        CompletableFuture<Item> fromChest = inventory.getFromChest();
        CompletableFuture<Item> bought = inventory.buy();
        //  CompletableFuture.allOf(fromChest, bought)
        //      .thenApply(v -> inventory.combine(fromChest.join(), bought.join()))
        //      .thenAccept(item -> System.out.println("Combined item: " + item));
        fromChest.thenCombine(bought, inventory::combine)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)));
        Thread.sleep(3000);
        System.out.println("Combined item: " + inventory);
    }
}
