package school.faang.bjs2_93030;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Launch {
    private static final int THREAD_POOL = 3;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_POOL);
    private static final int AWAIT_MINUTE = 1;

    public static void main(String[] args) {
        List<Potion> alchemicalShelf = List.of(
                new Potion("Зелье лечения", 2),
                new Potion("Зелье магии", 3),
                new Potion("Зелье силы", 2),
                new Potion("Зелье невидимости", 4),
                new Potion("Зелье сопротивления огню", 2),
                new Potion("Зелье яда", 3),
                new Potion("Зелье скорости", 2),
                new Potion("Зелье водного дыхания", 3),
                new Potion("Зелье парализации", 4),
                new Potion("Зелье восстановления выносливости", 2)
        );
        AlchemicalTable alchemicalTable = new AlchemicalTable();
        int scoreIngredient = alchemicalShelf.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> alchemicalTable.searchIngredient(potion), EXECUTOR))
                .map(CompletableFuture::join)
                .reduce(0, Integer::sum);
        log.info("Все ингредиенты собраны - {}", scoreIngredient);
        shutdown();

    }

    private static void shutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(AWAIT_MINUTE, TimeUnit.MINUTES)) {
                log.info("Потоки не остановились за {} - минут. Останавливаем потоки", AWAIT_MINUTE);
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ошибка при ожидании потоков");
        }
    }
}
