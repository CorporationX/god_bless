package school.faang.module1.bjs2_82746;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int POOL_SIZE = 4;
    private static final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) {
        Inventory inventory = new Inventory(executor);

        CompletableFuture<Item> itemFromChest = inventory.getFromChest();
        CompletableFuture<Item> itemFromShop = inventory.getFromShop();
        itemFromChest.thenCombine(itemFromShop, ((inventory::combineItems)))
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item), executor))
                .join();

        log.info("Все предметы в инвентаре: {}", inventory.getItems());

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи завершились вовремя. Принудительное завершение");
                executor.shutdownNow();
            } else {
                System.out.println("Пул потоков завершён корректно");
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван во время ожидания завершения пула");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}