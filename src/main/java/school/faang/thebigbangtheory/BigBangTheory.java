package school.faang.thebigbangtheory;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BigBangTheory {
    private static final Logger LOGGER = Logger.getLogger(Task.class.getName());

    public static void main(String[] args) {
        int threadCount = 4;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        Map<String, Goal> tasks = Map.of("Sheldon", Goal.THEORY,
                "Leonard", Goal.MODELING,
                "Howard", Goal.DEVELOPMENT,
                "Rasher", Goal.ANALYTICS);
        for (var task : tasks.entrySet()) {
            String name = task.getKey();
            Goal goal = task.getValue();
            executor.submit(new Task(name, goal));
        }
        executor.shutdown();

        try {
            int second = 5;
            if (!executor.awaitTermination(second, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                LOGGER.info("Не все потоки успели завершиться за " + second + " секунд");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.severe("Ожидание завершения потоков было прервано: " + e.getMessage());
        }
        LOGGER.info("Программа успешно завершилась");
    }
}
