package school.faang.bjs2_94777;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

@Slf4j
public class InventoryManager {
    private static final Random random = new Random();
    private int endSeeds;

    public void start(ExecutorService executor) {
        CompletableFuture<Item> futureItemChest = getFutureItemChest(executor);
        CompletableFuture<Item> futureItemMagazine = getFutureItemMagazine(executor);
        CompletableFuture.allOf(futureItemChest, futureItemMagazine);
        Inventory inventory = new Inventory();
        try {
            inventory.combineItems(futureItemChest, futureItemMagazine, executor).get();
        } catch (InterruptedException e) {
            log.error("Прерывание потока, при комбинировании предметов");
        } catch (ExecutionException e) {
            log.error("{} - Ошибка в получении результата при комбинировании предметов", e.getCause().getMessage());
        }
    }

    private CompletableFuture<Item> getFutureItemChest(ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            Chest chest = new Chest();
            endSeeds = chest.getChest().size();
            Item getItem = chest.getChestItem(random.nextInt(endSeeds));
            log.info("Коментатор - {}: Игрок достал предмет из инвентаря - {} - название предмета, {} - сила предмета",
                    Thread.currentThread().getName(), getItem.getName(), getItem.getPower());
            return getItem;
        }, executor);
    }

    private CompletableFuture<Item> getFutureItemMagazine(ExecutorService executor) {
        Magazine magazine = new Magazine();
        return CompletableFuture.supplyAsync(() -> {
            Item getItem = magazine.getMagazineItem(random.nextInt(endSeeds));
            log.info("Коментатор - {}: Игрок купил предмет в магазине - {} - название, {} - сила",
                    Thread.currentThread().getName(), getItem.getName(), getItem.getPower());
            return getItem;
        }, executor);
    }

}
