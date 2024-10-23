package school.faang.multithreading.asynchronism.carry.overfed;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class CombineService {
    private static final int TIME_TO_SLEEP = 1000;

    public Item combineItems(Item item1, Item item2) {
        int newPower = item1.getPower() + item2.getPower();
        Item item = new Item("SuperItem" + newPower, newPower);
        log.info("Created new super item: {}", item);
        return item;
    }

    public CompletableFuture<Item> getItemFrom(String from, int power, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TIME_TO_SLEEP);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Item item = new Item("ItemFrom" + from, power);
            log.info("Received item from{}: {}", from, item);
            return item;
        }, executor);
    }
}
