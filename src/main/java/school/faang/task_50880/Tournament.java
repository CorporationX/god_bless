package school.faang.task_50880;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.concurrent.CompletableFuture;

@Getter
@Setter
@RequiredArgsConstructor
public class Tournament {
    private static final long SLEEP_TIME = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            setSleepTime(task);
            return task.getReward();
        }).thenApply((reward) -> {
            school
                    .getTeam()
                    .forEach(student -> student.setPoints(student.getPoints() + reward));
            return school;
        });
    }

    private void setSleepTime(Task task) {
        try {
            Thread.sleep(task.getDifficulty() * SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
