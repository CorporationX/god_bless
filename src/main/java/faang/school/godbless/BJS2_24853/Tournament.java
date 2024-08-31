package faang.school.godbless.BJS2_24853;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(task.getDifficulty());

                for (Student student : school.getStudents()) {
                    student.addPoints(task.getReward());
                }
            } catch (Exception exception) {
                log.error(exception.getMessage(), exception);
            }
            return school;
        });
    }
}
