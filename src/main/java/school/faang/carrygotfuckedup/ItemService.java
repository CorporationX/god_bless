package school.faang.carrygotfuckedup;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class ItemService {

    public CompletableFuture<Item> getItemFromChest(String name) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay();
            return new Item(name, ThreadLocalRandom.current().nextInt(10, 50));
        });
    }

    public CompletableFuture<Item> getItemFromShop(String name) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay();
            return new Item(name, ThreadLocalRandom.current().nextInt(20, 60));
        });
    }

    private void simulateDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

