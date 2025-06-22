package school.faang.bigbang;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Slf4j(topic = "BigBangTheory")
public class BigBangTheory {

    private static final int MAX_THREADS = 4;
    private static final int MAX_EXECUTOR_AWAIT_TERMINATION_TIME = 5;

    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(MAX_THREADS);
        var tasksByName = Map.of(
                "Шелдон", "подготовка теории",
                "Леонард", "моделирование эксперимента",
                "Говард", "разработка инструментов",
                "Раджеш", "анализ данных"
        );
        tasksByName.forEach((name, task) -> executor.execute(new Task(name, task)));
        executor.shutdown();
        var executorName = executor.getClass().getSimpleName();
        log.info("{} | Запрос на завершение работы", executorName);
        try {
            if (!executor.awaitTermination(MAX_EXECUTOR_AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info("{} | Принудительное завершение работы", executorName);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.error("{} | Принудительное завершение работы", executorName, e.getCause());
        }
        log.info("{} | Завершение работы", executorName);
    }
}
