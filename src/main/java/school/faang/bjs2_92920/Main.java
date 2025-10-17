package school.faang.bjs2_92920;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static final int WAITING_TIME = 2;

    public static void main(String[] args) {
        PotionService potionService = new PotionService();
        List<CompletableFuture<Integer>> completableFuturesResults = List.of(
                potionService.gatherIngredients(new Potion("для сверхсилы", 12)),
                potionService.gatherIngredients(new Potion("для сверхума", 17)),
                potionService.gatherIngredients(new Potion("для сверхловкости", 9)),
                potionService.gatherIngredients(new Potion("для сверххрабрости", 6))
        );
        AtomicInteger totalIngredientsAmount = new AtomicInteger();
        completableFuturesResults.forEach(completableFuture ->
                        completableFuture.thenApply(totalIngredientsAmount::addAndGet));
        potionService.getExecutor().shutdown();
        try {
            if (!potionService.getExecutor().awaitTermination(WAITING_TIME, TimeUnit.MINUTES)) {
                log.error("Мы устали собирать все ингридиенты, пора идти домой.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Мы не успели собрать ингредиенты для всех зелий, нагрянули охотники на ведьм!");
        }
        log.info("Итого собрано {} ингридиентов.", totalIngredientsAmount);
    }
}
