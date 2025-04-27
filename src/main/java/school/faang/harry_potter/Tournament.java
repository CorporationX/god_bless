package school.faang.harry_potter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<School> startTask(School school, Task task) {
        log.info("Школа {} начинает выполнение задания: {}", school.getName(), task.getName());

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);

                int pointsPerStudent = task.getReward() / school.getTeam().size();
                school.getTeam().forEach(student -> student.addPoints(pointsPerStudent));

                log.info("Школа {} выполнила задание {} и получила {} очков ({} на студента)",
                        school.getName(), task.getName(), task.getReward(), pointsPerStudent);
                return school;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Задание {} было прервано для школы {}", task.getName(), school.getName(), e);
                throw new RuntimeException("Выполнение задания прервано", e);
            }
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
