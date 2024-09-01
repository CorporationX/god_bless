package faang.school.godbless.carrygotfat;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Dota2Game {
    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            sleepRandom();
            Item item = new Item("Shield", 15);
            log.info("Got item from chest: {}", item);
            return item;
        });
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            sleepRandom();
            Item item = new Item("Sword", 10);
            log.info("Got item from shop: {}", item);
            return item;
        });
    }

    private void sleepRandom() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
    }
}