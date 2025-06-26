package school.faang.bjs2_82772;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final int DEFAULT_TIMELINE_IN_SEC = 5;
    private static final int NUM_THREADS = 4;
    private static final int TIMEOUT = 20;
    private final ExecutorService poolThread = Executors.newFixedThreadPool(NUM_THREADS);

    public CompletableFuture<School> startTask(School school, Task task) {
        Random random = new Random();

        return CompletableFuture.supplyAsync(
                        () -> {
                            log.info("Школа {} начала выполнять задание \"{}\"", school.getName(), task.getName());
                            int timeTask = (task.getDifficulty().getNumberDifficulty() * 3) / 2 + random.nextInt(3);
                            try {
                                TimeUnit.SECONDS.sleep(DEFAULT_TIMELINE_IN_SEC + timeTask);
                            } catch (InterruptedException e) {
                                log.error("Задание \"{}\" было прервано", task.getName(), e);
                                throw new RuntimeException(e);
                            }
                            log.info("Школа {} выполнила задание {}", school.getName(), task.getName());
                            return task.getReward();
                        },
                        poolThread)
                .thenApply(
                        reward -> {
                            school.getTeam()
                                    .forEach(student -> student.gainPoints(
                                            random.nextInt(reward + random.nextInt(5))));
                            return school;
                        });
    }

    public void breakPoolThread() {
        poolThread.shutdown();
        try {
            if (!poolThread.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                poolThread.shutdownNow();
                log.info("Досрочное завершение потоков");
            }
        } catch (InterruptedException e) {
            poolThread.shutdownNow();
        }
    }
}
