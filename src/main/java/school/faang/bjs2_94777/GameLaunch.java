package school.faang.bjs2_94777;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GameLaunch {
    private static final int THREAD_COUNT = 10;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_COUNT);
    private static final int AWAIT_MINUTES = 1;
    private static final int INDEX_ITEM = 1;

    public static void main(String[] args) {
        CompletableFuture<Item> futureItemChest = CompletableFuture.supplyAsync(() -> {
            Chest chest = new Chest();
            Item getItem = chest.getChestItem(INDEX_ITEM);
            log.info("Коментатор - {}: Игрок достал предмет из инвентаря - {} - название предмета, {} - сила предмета",
                    Thread.currentThread().getName(), getItem.getName(), getItem.getPower());
            return getItem;
        }, EXECUTOR);
        CompletableFuture<Item> futureItemMagazine = CompletableFuture.supplyAsync(() -> {
            Magazine magazine = new Magazine();
            Item getItem = magazine.getMagazineItem(INDEX_ITEM);
            log.info("Коментатор - {}: Игрок купил предмет в магазине - {} - название, {} - сила",
                    Thread.currentThread().getName(), getItem.getName(), getItem.getPower());
            return getItem;
        }, EXECUTOR);
        Inventory inventory = new Inventory();
        inventory.combineItems(futureItemChest, futureItemMagazine, EXECUTOR);
        shutdown();
    }

    private static void shutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(AWAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Потоки не закончили работу за {} минут. Останавливаем потоки", AWAIT_MINUTES);
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ошибка в ожидании завершения работы потоков");
        }
    }
}
