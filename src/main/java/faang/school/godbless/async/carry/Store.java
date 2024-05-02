package faang.school.godbless.async.carry;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Store {
    private static final Long BUYING_TIMING = 1500L;
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final List<Item> items;

    public Store(List<Item> items) {
        this.items = items;
    }

    public CompletableFuture<Item> buyItem(int itemIndex) {
        if (items.size() < itemIndex + 1) {
            throw new NoSuchElementException("Someone tried to buy the item by indes " + itemIndex + ". The attempt failed. The store doesn't contain this item.");
        }

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(0, BUYING_TIMING));
            } catch (InterruptedException e) {
                log.error("Buying second item was interrupted.");
            }

            Item soldItem = items.remove(1);

            log.info("Sold the " + soldItem + " to some fellow hero.");

            return soldItem;
        }, executor);
    }

    public void close() {
        executor.shutdown();
    }
}
