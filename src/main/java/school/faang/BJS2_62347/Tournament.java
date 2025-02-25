package school.faang.BJS2_62347;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final long MILLISECONDS_IN_SECOND = 100;

    public CompletableFuture<School> startTask(School school, Task task) {
        if (school == null || task == null) {
            throw new IllegalArgumentException("Player и Quest не могут быть null");
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) task.getDifficulty() * MILLISECONDS_IN_SECOND);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток был прерван во время выполнения квеста", e);
                throw new RuntimeException("Поток был прерван", e);
            }

            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }

            return school;
        });
    }
}

