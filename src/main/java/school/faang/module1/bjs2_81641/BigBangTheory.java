package school.faang.module1.bjs2_81641;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {

    private static final int POOL_SIZE = 4;
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        List<Task> tasks = List.of(
                new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных")
        );
        for (Task task : tasks) {
            executorService.execute(task);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Некоторые задачи не завершились вовремя, принудительное завершение");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Главный поток был прерван", e);
            executorService.shutdownNow();
        }
        log.info("все задачи завершены успешно");
    }
}