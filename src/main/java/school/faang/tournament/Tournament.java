package school.faang.tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament implements AutoCloseable {

    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final List<School> schools;

    public Tournament(List<School> schools) {
        Objects.requireNonNull(schools, "Schools list cannot be null");
        this.schools = schools;
    }

    public CompletableFuture<School> startTask(School school, Task task) {
        Objects.requireNonNull(school, "School cannot be null");
        Objects.requireNonNull(task, "Task cannot be null");

        return CompletableFuture.supplyAsync(() -> {
            log.info("{} starts task {}", school.getName(), task.getName());
            try {
                Thread.sleep(calculateTaskTime(task));
            } catch (InterruptedException e) {
                log.error("Caught exception", e);
                throw new IllegalStateException(
                        String.format("Thread %s interrupted", Thread.currentThread().getName()), e
                );
            }
            log.info("{} ends task {}. Each student got {} points", school.getName(), task.getName(), task.getReward());
            school.getTeam().forEach(student -> student.addPoints(task.getReward()));
            return school;
        }, executor);
    }

    public void chooseWinner() {
        Optional<School> winner = schools.stream().max(Comparator.comparingInt(School::getTotalPoints));
        String message = winner
                .map(school -> school.getName() + " wins the tournament!")
                .orElse("No one participated!");
        log.info(message);
    }

    @Override
    public void close() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private int calculateTaskTime(Task task) {
        return switch (task.getDifficulty()) {
            case EASY -> 1_000;
            case MEDIUM -> 2_000;
            case HARD -> 3_000;
        };
    }
}
