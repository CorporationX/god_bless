package faang.school.godbless.sprint2.dota2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        inventory.getItemFromBox()
                .thenCombine(inventory.getItemFromShop(), inventory::combineItems)
                .thenCompose((item -> CompletableFuture.runAsync(() -> inventory.addItem(item), executor)));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        log.info("Закончили");
    }
}
