package school.faang.task_62449;

import java.util.List;
import java.util.Optional;
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

    public void determineWinner(List<CompletableFuture<School>> futures, School schoolA, School schoolB) {
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allTasks.thenRun(() -> {
            int pointsA = schoolA.getTotalPoints();
            int pointsB = schoolB.getTotalPoints();

            log.info("'{}': {} points, '{}' : {} points", schoolA.name(), pointsA, schoolB.name(), pointsB);

            getWinner(schoolA, schoolB)
                    .ifPresentOrElse(
                            winner -> log.info("'{}' wins!", winner),
                            () -> log.info("No winner, it's a tie!"));
        }).join();
    }

    private Optional<String> getWinner(School schoolA, School schoolB) {
        return (schoolA.getTotalPoints() > schoolB.getTotalPoints())
                ? Optional.of(schoolA.name()) : (schoolA.getTotalPoints() < schoolB.getTotalPoints())
                ? Optional.of(schoolB.name()) : Optional.empty();
    }
}
