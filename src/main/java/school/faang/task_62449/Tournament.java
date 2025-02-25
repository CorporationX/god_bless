package school.faang.task_62449;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tournament {
    private static final long DIFFICULTY_MULTIPLIER = 1000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        log.info("Task '{}' started for '{}'", task.name(), school.name());
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.difficulty() * DIFFICULTY_MULTIPLIER);
            } catch (InterruptedException e) {
                log.error("Task interrupted: {}", e.getMessage(), e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            school.team().forEach(student -> student.addPoints(task.reward()));
            log.info("Task '{}' completed for '{}'", task.name(), school.name());
            return school;
        });
    }

    public void determineWinner(List<CompletableFuture<School>> futures, School hogwarts, School beauxbatons) {
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allTasks.thenRun(() -> {
            int hogwartsPoints = hogwarts.getTotalPoints();
            int beauxbatonsPoints = beauxbatons.getTotalPoints();
            String winner = "";

            log.info("'{}': {} points, '{}' : {} points", hogwarts.name(), hogwartsPoints,
                    beauxbatons.name(), beauxbatonsPoints);

            if (hogwartsPoints > beauxbatonsPoints) {
                winner = hogwarts.name();
            } else if (hogwartsPoints < beauxbatonsPoints) {
                winner = beauxbatons.name();
            } else {
                log.info("It's a tie!");
            }

            if (!winner.isEmpty()) {
                log.info("'{}' wins!", winner);
            } else {
                log.info("No winner, it's a tie!");
            }

        }).join();
    }
}
