package school.faang.thebigbangtheory;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int TASK_TIMEOUT_SECONDS = 5;

    public static void main(String[] args) {
        int threadCount = 4;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        Map<String, Goal> tasks = Map.of("Sheldon", Goal.THEORY,
                "Leonard", Goal.MODELING,
                "Howard", Goal.DEVELOPMENT,
                "Rajesh", Goal.ANALYTICS);
        for (var task : tasks.entrySet()) {
            String name = task.getKey();
            Goal goal = task.getValue();
            executor.submit(new Task(name, goal));
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TASK_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info("Не все потоки успели завершиться за " + TASK_TIMEOUT_SECONDS + " секунд");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ожидание завершения потоков было прервано: {}", e.getMessage());
        }
        log.info("Программа успешно завершилась");
    }
}
