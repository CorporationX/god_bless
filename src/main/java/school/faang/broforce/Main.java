package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static school.faang.broforce.EventType.LIVES_DOWN;
import static school.faang.broforce.EventType.SCORES_UP;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        var game = new Game();
        var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (var i = 0; i < 100; i++) {
            executor.execute(() -> game.update(SCORES_UP));
        }
        for (var i = 0; i < 51; i++) {
            executor.execute(() -> game.update(LIVES_DOWN));
        }
        executor.shutdown();
        log.info("{} | Запрос на завершение работы", executor.getClass().getSimpleName());
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.error("{} | Принудительное завершение работы", executor.getClass().getSimpleName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.error("Поток {} прерван; {} | Принудительное завершение работы",
                    Thread.currentThread().getName(), executor.getClass().getSimpleName(), e.getCause());
        }
        log.info("{} | Завершение работы", executor.getClass().getSimpleName());
        log.info("Очки опыта: {}; Потеряно жизней: {}", game.getScore(), game.getLives());
    }
}
