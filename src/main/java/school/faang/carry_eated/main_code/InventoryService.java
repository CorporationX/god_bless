package school.faang.carry_eated.main_code;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class InventoryService {
    private static final int THREAD_COUNT = 5;

    private ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
    private Invertory invertory = new Invertory();

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Ошибка при получении предмета из сундука");
                throw new RuntimeException(e);
            }

            return new Item("даедалус", 15);
        }, executor);
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Ошибка при получении предмета из магазина");
                throw new RuntimeException(e);
            }

            return new Item("рапира", 25);
        }, executor);
    }

    public CompletableFuture<Void> combineAndAddToInventory() {
        CompletableFuture<Item> getItemFromChest = getItemFromChest();
        CompletableFuture<Item> getItemFromShop = getItemFromShop();

        return getItemFromChest.thenCombine(getItemFromShop,
                ((item1, item2) -> invertory.combineItem(item1, item2)))
                .thenCompose(result -> CompletableFuture.runAsync(() -> invertory.addItem(result), executor));
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Ошибка при попытке закрыть пулл потоков");
            executor.shutdownNow();
        }
    }
}
