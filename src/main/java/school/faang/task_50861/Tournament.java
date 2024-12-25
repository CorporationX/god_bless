package school.faang.task_50861;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final int TIME_OUT_MS = 1000;

    public static CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * TIME_OUT_MS);
            } catch (InterruptedException e) {
                log.error("Error {}", e.getMessage());
                e.printStackTrace();
            }

            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }
            return school;
        });
    }
}