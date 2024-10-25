package school.faang.Multithreading.sprint_4.CurryEat;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class DistributionItems {
    public static final long TIME_ITEM_FROM_CHEST = 3_000;
    public static final long TIME_ITEM_FROM_STORE = 4_000;

    public CompletableFuture<Item> getItemFromChest(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TIME_ITEM_FROM_CHEST);
            } catch (InterruptedException e) {
                log.error("Ошибка", e);
                throw new RuntimeException(e);
            }
            return new Item("Sword", 12);
        });
    }

    public CompletableFuture<Item> getItemFromStore(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TIME_ITEM_FROM_STORE);
            } catch (InterruptedException e) {
                log.error("Ошибка", e);
                throw new RuntimeException(e);
            }
            return new Item("Staff", 16);
        });
    }

}
