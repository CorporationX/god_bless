package school.faang.BJS2_92822;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Slf4j
public class Tournament {
    private static final int DEFAULT_TIME_SLEEP = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
            synchronized (school) {
                int point = task.getReward();
                int difficulty = task.getDifficulty();
                sleepThread(DEFAULT_TIME_SLEEP * task.getDifficulty());
                school.getTeam().forEach((student) -> {
                    student.setPoints(student.getPoints() + point);
                    log.info("Cтудент {} школы {} имеет очков - {}",
                            student.getName(), school.getName(), student.getPoints());
                });
                return school;
            }
        });
        return future;
    }

    private void sleepThread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
