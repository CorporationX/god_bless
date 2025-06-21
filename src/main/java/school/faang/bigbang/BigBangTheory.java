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

    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(4);
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
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
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
