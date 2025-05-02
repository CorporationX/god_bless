package school.faang.sprint4_future_async.thetriwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

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
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}