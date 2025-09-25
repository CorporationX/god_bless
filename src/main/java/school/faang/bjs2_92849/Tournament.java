package school.faang.bjs2_92849;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class Tournament {
    private static final int THREAD_SLEEP_MS = 1000;

    public CompletableFuture<School> startTask(School school, Task task, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int delay = task.getDifficulty() * THREAD_SLEEP_MS;
                Thread.sleep(delay);

                school.getTeam().forEach(student ->
                        student.addPoints(task.getReward()));

                return school;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Задание было прервано для школы {}: {}", school.getName(), e.getMessage());
                return school;
            }
        }, executor);
    }
}
