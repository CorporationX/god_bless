package school.faang.weasley;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Danil Pudovkin
 * @since 17.06.2025
 */
@Slf4j
public class WeasleyFamily {

    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин");

    public void doChores() {
        log.info("Начало работы {}", executor.getClass().getSimpleName());
        for (var chore : chores) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();
        log.info("Завершение работы {}", executor.getClass().getSimpleName());
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info("Принудительное завершение работы {}", executor.getClass().getSimpleName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.error("Получено прерывание {}; Принудительное завершение работы {}",
                    e.getMessage(), executor.getClass().getSimpleName());
        }
    }
}
