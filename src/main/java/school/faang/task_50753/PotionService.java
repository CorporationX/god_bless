package school.faang.task_50753;

import lombok.extern.slf4j.Slf4j;
import school.faang.exception.CheckException;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionService {
    private final AtomicInteger totalIngredients = new AtomicInteger(0);
    private static final int SLEEP_DURATION = 5000;

    public void gatherAllIngredients(List<Potion> potionList, ExecutorService executor) {
        if (potionList == null || potionList.isEmpty()) {
            throw new CheckException("potionList");
        }
        List<CompletableFuture<Integer>> futures = potionList.stream()
                .filter(Objects::nonNull)
                .map(potion -> gatherIngredients(potion, executor))
                .toList();

        CompletableFuture<?>[] futuresArray = futures.toArray(new CompletableFuture[0]);

        CompletableFuture.allOf(futuresArray)
                .thenRun(() -> {
                    futures.forEach(future -> totalIngredients.addAndGet(future.join()));
                    System.out.println("totalIngredients: " + totalIngredients.get());
                })
                .exceptionally((e) -> {
                    log.error(e.getMessage());
                    return null;
                });
    }

    private CompletableFuture<Integer> gatherIngredients(Potion potion, ExecutorService executor) {
        if (potion == null) {
            throw new CheckException("potion");
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            return potion.getRequiredIngredients();
        }, executor);
    }
}
