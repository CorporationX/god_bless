package school.faang.bjs2_92960;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    public static void main(String[] args) {
        final ExecutorService ex = Executors.newFixedThreadPool(3);

        PotionServices service = new PotionServices();

        final List<Potion> potions = List.of(new Potion("Healing salve", 2),
                new Potion("Bismuth flask", 5),
                new Potion("Quicksilver flask", 3));


        List<CompletableFuture<Void>> futures = potions.stream()
                .map(service::gatherIngredient)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();
        log.info("Total ingredients: {}", service.getAtomInt().get());

        ex.shutdown();
        try {
            if (!ex.awaitTermination(15, TimeUnit.SECONDS)) {
                ex.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
    }
}
