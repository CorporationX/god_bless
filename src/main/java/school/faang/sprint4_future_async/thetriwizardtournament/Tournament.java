package school.faang.sprint4_future_async.thetriwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {

    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);

    public CompletableFuture<School> startTask(School school, Task task) {
        log.info("Начато выполнение задачи '{}' для школы {}", task.getName(), school.getName());
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(task.getDifficulty());
            } catch (InterruptedException e) {
                log.error("ОШIБКА: ", e);
                Thread.currentThread().interrupt();
            }
            school.getStudents()
                    .forEach(student -> student.addPoints(task.getReward()));
            return school;
        }, EXECUTOR);
    }

    public void shutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(1, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}