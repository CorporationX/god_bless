package school.faang.bjs2_92920;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class PotionService {
    private static final int GATHERING_DURATION = 5;
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Начинаем сборку ингридиентов для зелья '{}'.", potion.getName());
                TimeUnit.SECONDS.sleep(GATHERING_DURATION);
                log.info("Закончили сборку ингридиентов для зелья '{}'.", potion.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Пришлось прервать сборку ингридиентов для зелья {}, нас поймали охотники на ведьм.",
                        potion.getName());
            }
            return potion.getRequiredIngredients();
        }, executor);
    }
}
