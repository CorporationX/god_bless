package school.faang.BJS2_38970_TriwizardTournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final int MILLISECONDS_IN_SECOND = 1_000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("The team of school {} started the task {}", school.getName(), task.getName());
            try {
                Thread.sleep((long) task.getDifficulty() * MILLISECONDS_IN_SECOND);
            } catch (InterruptedException e) {
                log.error(
                        "Thread {} was interrupted while the team of school {} was completing the task {}!",
                        Thread.currentThread().getName(), school.getName(), task.getName(),
                        e
                );
            }
            school.updateStudentsPoints(task.getReward());
            log.info("The team of school {} completed the task {}", school.getName(), task.getName());
            return school;
        });
    }
}
