package school.faang.magic_tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final long SLEEP_MULTIPLIER = 200L;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getReward() * SLEEP_MULTIPLIER);
            } catch (InterruptedException e) {
                log.error("Thread {} running was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
            school.getTeam()
                    .forEach(student -> {
                        student.addPoints(task.getReward());
                        log.info("Student {} have got {} points", student.getName(), task.getReward());
                    });
            return school;
        });
    }
}
