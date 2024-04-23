package faang.school.godbless.bjs2_5939;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {

    private static final AtomicInteger ingredients = new AtomicInteger(0);

    public static void main(String[] args) {

        List<Potion> potions = List.of(new Potion("Cure Potion", 4),
                new Potion("Health Potion", 5),
                new Potion("Magick Potion", 6),
                new Potion("Stamina Potion", 3),
                new Potion("Resistance Potion", 5));

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Main::gatherIngredients)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .toList())
                .join().forEach(ingredients::getAndAdd);

        log.info("Total ingredients: {}", ingredients.get());
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(potion.getRequiredIngredients());
                log.info("Ingredients for {} collected", potion.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}
